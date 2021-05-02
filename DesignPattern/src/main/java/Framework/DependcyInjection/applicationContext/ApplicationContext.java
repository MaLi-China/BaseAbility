package Framework.DependcyInjection.applicationContext;

/**
 * 功能说明：DI容器执行入口
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/2
 */
public interface ApplicationContext {
    /**
     * 获取容器中创建的对象
     *
     * @param beanId 配置文件中的beanId
     * @return 返回容器中创建的对象
     */
    Object getBean(String beanId);
}
