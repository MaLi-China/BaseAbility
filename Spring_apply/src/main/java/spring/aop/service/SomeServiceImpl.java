package spring.aop.service;

/**
 * 模拟业务方法: 等待被aop增强
 *
 * @Author MaLi
 */
public class SomeServiceImpl {
    public void method() {
        System.out.println("简单的业务方法...");
    }

    public void method_withException() {
        System.out.println("产生异常的业务方法...");
        throw new RuntimeException("抛出一个运行时异常...");
    }
}
