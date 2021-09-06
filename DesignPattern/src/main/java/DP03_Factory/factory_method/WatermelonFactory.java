package DP03_Factory.factory_method;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class WatermelonFactory implements FruitFactory {
    @Override
    public IFruit produceFruit() {
        return new WatermelonFruit();
    }
}
