package StructuralPattern.Proxy.StaticProxy;

/**
 * 功能说明：模拟静态代理类 实现性能指标收集
 * 1, 继承被代理类;
 * 2, 通过委托被代理类执行具体的业务逻辑
 * <p>
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/3
 */
public class UserControllerProxy_UseExtends extends UserControllerImpl {
    private MetricsCollector metricsCollector = new MetricsCollector();

    @Override
    public void login(String telephone, String password) {
        //1,  do some metrics colletion...

        //2, 委托
        super.login(telephone, password);

        //3, do some metrics colletion...

        //4, collect metrics into some object
        metricsCollector.recordRequest(new Object());
    }

    @Override
    public void register(String telephone, String password) {
        //1,  do some metrics colletion...

        //2, 委托
        super.register(telephone, password);

        //3, do some metrics colletion...

        //4, collect metrics into some object
        metricsCollector.recordRequest(new Object());
    }
}
