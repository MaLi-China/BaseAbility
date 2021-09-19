package DP21_Template.TemplateCode;

/**
 * 功能说明：模板模式的模板代码
 * 开发人员：@author MaLi
 */
public abstract class AbstractClass {

    // 父类的代码中负责创建业务逻辑的流程, 具体的实现由子类去实现
    public final void templateMethod() {
        //...其它业务逻辑...
        this.method1(); //将具体逻辑推迟到子类去实现
        //...其它业务逻辑...
        this.method2(); //将具体逻辑推迟到子类去实现
        //...其它业务逻辑...
    }

    // 未知的逻辑细节, 由子类去实现
    protected abstract void method1();

    // 未知的逻辑细节, 由子类去实现
    protected abstract void method2();

}
