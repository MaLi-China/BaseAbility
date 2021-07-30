package package2;

import package1.TestObject;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class TestObjectSon extends TestObject {
    public static void main(String[] args) {
        TestObject testObject = new TestObject();
        TestObjectSon testObjectSon = new TestObjectSon();
        System.out.println(testObjectSon.name);
    }
}
