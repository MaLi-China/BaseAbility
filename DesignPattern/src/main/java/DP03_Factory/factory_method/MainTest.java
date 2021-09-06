package DP03_Factory.factory_method;

import org.junit.Test;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MainTest {
    @Test
    public void testFruitFactory() {
        FruitFactory factory = new AppleFactory();
        IFruit fruit = factory.produceFruit();
        fruit.showCategory();
    }
}
