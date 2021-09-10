package DP03_Factory.factory_method;

import org.junit.Test;

/**
 * 功能说明：
 * 工厂方法解决的问题: 扩展性, 每新添加一种对象, 就添加一个工厂, 既满足了扩展性, 又解耦了对象的使用和创建过程.
 * 开发人员：@author MaLi
 */
public class MainTest {
    @Test
    public void testFruitFactory() {
        //生产中直接注入工厂
        FruitFactory factory = new AppleFactory();
        IFruit fruit = factory.produceFruit();
        fruit.showCategory();
    }
}
