package proxy.bean;

import org.junit.Test;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MainTest {
    @Test
    public void MT1_CglibProxy() {
        IAction action = ProxyFactory.getCglibProxy();
        action.doaction();
        System.out.println("------------------------------分割线------------------------------");
        action = ProxyFactory.getJDKProxy();
        action.doaction();
    }
}
