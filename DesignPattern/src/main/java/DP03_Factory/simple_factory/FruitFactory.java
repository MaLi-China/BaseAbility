package DP03_Factory.simple_factory;

/**
 * 功能说明：简单工厂
 * 存在意义: 真实生产, 创建对象可能是一个比较复杂的过程, 所以可以解耦到工厂中. 让使用对象的客户端可以不用关心创建过程
 * 简单工厂的不足: 如果需求中不断添加新的对象, 那么就需要不断改动工厂类, 扩展性不足, 不符合开闭原则.
 * 升级方案: 工厂方法
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
