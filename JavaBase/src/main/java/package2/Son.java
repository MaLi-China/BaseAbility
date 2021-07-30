package package2;

import package1.Parent;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class Son extends Parent {
    @Override
    public void showMsg() {
        System.out.println("display public");
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.showMsg();
    }
}
