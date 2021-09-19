package DP21_Template.TemplateCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class ApplicationDemo {
    public static void main(String[] args) {
        List<AbstractClass> list = new ArrayList<>();
        list.add(new ConcreteClass1());
        list.add(new ConcreteClass2());
        for (AbstractClass instance : list) {
            instance.method1();
            instance.method2();
        }
    }
}