package DP03_Factory.factory_method;

/**
 * 功能说明：工厂方法, 定义工厂具备的行为
 * 开发人员：@author MaLi
 */
public interface FruitFactory {
    /**
     * 让所有的工厂约定, 来产出水果.
     *
     * @return IFruit
     */
    IFruit produceFruit();
}
