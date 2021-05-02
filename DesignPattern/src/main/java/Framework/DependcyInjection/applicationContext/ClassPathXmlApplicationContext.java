package Framework.DependcyInjection.applicationContext;

import Framework.DependcyInjection.beanConfigParser.BeanConfigParser;
import Framework.DependcyInjection.beanConfigParser.impl.XmlBeanConfigParser;
import Framework.DependcyInjection.beanFactory.BeansFactory;
import Framework.DependcyInjection.domain.BeanDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 功能说明：程序入口 - 通过xml配置文件创建对象
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/2
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private BeansFactory beansFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    /**
     * @param configLocation 配置文件位置
     */
    public void loadBeanDefinitions(String configLocation) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + configLocation);
            if (in == null) {
                throw new RuntimeException("Can not find config file: " + configLocation);
            }
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
        }
    }

    /**
     * 获取容器中创建的对象
     *
     * @param beanId 配置文件中的beanId
     * @return 返回容器中创建的对象
     */
    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
