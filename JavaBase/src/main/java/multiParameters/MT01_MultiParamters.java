package multiParameters;

import org.junit.Test;

/**
 * 功能说明：可变参数测试
 * 开发人员：@author MaLi
 */
public class MT01_MultiParamters {
    public static void M01_doAction(Object param, Object... params) {
        System.out.println(params.length);
        System.out.println(params); //隐式调用
    }

    @Test
    public void TM01_doAction() {
        M01_doAction(1, 2, 3, 4, 5, 6);
    }
}
