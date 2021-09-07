package DP04_Decorator;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        RedShapeDecorator circle_redShapeDecorator = new RedShapeDecorator(new Circle());
        RedShapeDecorator rectangle_redShapeDecorator = new RedShapeDecorator(new Rectangle());
        circle_redShapeDecorator.draw();
        rectangle_redShapeDecorator.draw();
    }
}
