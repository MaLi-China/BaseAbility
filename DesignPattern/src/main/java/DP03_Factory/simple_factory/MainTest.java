package DP03_Factory.simple_factory;

import org.junit.Test;

/**
 * 功能说明：测试简单工厂设计模式
 * 开发人员：@author MaLi
 */
public class MainTest {
    @Test
    public void testIFruit() {
        IFruit fruit = FruitFactory.getFruit("watermelon");
        fruit.showCategory();
        fruit = FruitFactory.getFruit("apple");
        fruit.showCategory();
    }
}
