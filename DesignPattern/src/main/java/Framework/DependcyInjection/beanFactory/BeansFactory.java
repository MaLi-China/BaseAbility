package Framework.DependcyInjection.beanFactory;

import Framework.DependcyInjection.domain.BeanDefinition;
import Framework.DependcyInjection.exceptions.NoSuchBeanDefinitionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能说明：负责创建对象的工厂类
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/2
 */
public class BeansFactory {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    /**
     * 把解析到的beanDefinition放到容器中
     *
     * @param beanDefinitions 解析好的配置文件元素对象:  beanDefinitions
     */
    public void addBeanDefinitions(List<BeanDefinition> beanDefinitions) {
        for (BeanDefinition beanDefinition : beanDefinitions) {
            this.beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);
        }
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        if (beanDefinition == null) {
            try {
                throw new NoSuchBeanDefinitionException("Bean is not defined: " + beanId);
            } catch (NoSuchBeanDefinitionException e) {
                e.printStackTrace();
            }
        }
        return createBean(beanDefinition);
    }

    private Object createBean(BeanDefinition beanDefinition) {
        if (beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition.getId())) {
            return singletonObjects.get(beanDefinition.getId());
        }
        Object bean = null;


        try {
            //1, 反射字节码对象
            Class beanClass = Class.forName(beanDefinition.getClassName());
            //2, 根据构造函数是否有参数执行不同的创建方式
            List<BeanDefinition.ConstrctorArg> constrctorArgs = beanDefinition.getConstrctorArgs();
            if (constrctorArgs.isEmpty()) {
                bean = beanClass.newInstance();
            } else {
                Class[] argClasses = new Class[constrctorArgs.size()];
                Object[] argObjects = new Object[constrctorArgs.size()];
                // 获取配置文件的参数, 保存到argClasses与argObjects中
                for (int i = 0; i < constrctorArgs.size(); i++) {
                    BeanDefinition.ConstrctorArg arg = constrctorArgs.get(i);
                    if (!arg.isRef()) {
                        // 参数不是引用数据类型
                        argClasses[i] = arg.getType();
                        argObjects[i] = arg.getArg();
                    } else {
                        // 参数是引用数据类型
                        BeanDefinition refBeanDefinition = beanDefinitions.get(arg.getArg());
                        if (refBeanDefinition == null) {
                            throw new NoSuchBeanDefinitionException("Bean is not defined: " + arg.getArg());
                        }
                        argClasses[i] = Class.forName(refBeanDefinition.getClassName());
                        argObjects[i] = createBean(refBeanDefinition);
                    }
                }
                bean = beanClass.getConstructor(argClasses).newInstance(argObjects);

            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            logger.error(e.getMessage());
        }
        // 针对单例对象, 加入到容器中去, 下次获取直接找单例容器获取
        if (bean != null && beanDefinition.isSingleton()) {
            singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
            return singletonObjects.get(beanDefinition.getId());
        }
        return bean;
    }
}
