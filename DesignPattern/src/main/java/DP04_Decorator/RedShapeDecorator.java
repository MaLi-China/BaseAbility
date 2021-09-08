package DP04_Decorator;

/**
 * 功能说明：装饰设计模式
 * 开发人员：@author MaLi
 */
public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShap.draw();
        this.setRedBorder(decoratedShap);
    }

    //个性化的方法
    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }

}
