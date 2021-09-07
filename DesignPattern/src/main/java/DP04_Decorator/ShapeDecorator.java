package DP04_Decorator;

/**
 * 功能说明：Shape的装饰类
 * 开发人员：@author MaLi
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShap;

    public ShapeDecorator(Shape decoratedShap) {
        this.decoratedShap = decoratedShap;
    }

    @Override
    public void draw() {
        decoratedShap.draw();
    }
}
