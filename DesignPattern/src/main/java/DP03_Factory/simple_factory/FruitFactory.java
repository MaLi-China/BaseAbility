package DP03_Factory.simple_factory;

/**
 * 功能说明：简单工厂
 * 问题: 每添加一种新的接口实现, 就要改动该工厂类, 不符合开闭原则.
 * 存在意义: 任意定制接口的实现
 * 开发人员：@author MaLi
 */
public class FruitFactory {
    // 存在意义: 可以根据传入的参数, 任意定制接口的实现类
    // 缺点: 不符合开闭原则, 在明确数量的场景适合使用
    public static IFruit getFruit(String fruitName) {
        IFruit fruit = null;
        if ("Apple".equalsIgnoreCase(fruitName)) {
            fruit = new FruitImpl_Apple();
        } else if ("watermelon".equalsIgnoreCase(fruitName)) {
            fruit = new FruitImpl_Watermelon();
        }
        return fruit;
    }
}
