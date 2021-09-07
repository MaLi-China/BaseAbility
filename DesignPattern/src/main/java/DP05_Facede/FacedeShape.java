package DP05_Facede;

/**
 * 功能说明：门面, 接待者, 隐藏内部复杂的关系, 对外提供一个统一的接待者
 * 开发人员：@author MaLi
 */
public class FacedeShape {
    private Circle circle;
    private Rectangle rectangle;
    private SomeOtherShape someOtherShape;

    public FacedeShape(Circle circle, Rectangle rectangle, SomeOtherShape someOtherShape) {
        this.circle = circle;
        this.rectangle = rectangle;
        this.someOtherShape = someOtherShape;
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSomeOtherShape() {
        someOtherShape.draw();
    }
}
