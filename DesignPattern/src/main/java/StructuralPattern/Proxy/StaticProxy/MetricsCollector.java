package StructuralPattern.Proxy.StaticProxy;

/**
 * 功能说明：指标收集器
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/3
 */
public class MetricsCollector {
    /**
     * 模拟指标收集
     *
     * @param some
     */
    public void recordRequest(Object some) {
        System.out.println("metrics has been collected");
    }
}
