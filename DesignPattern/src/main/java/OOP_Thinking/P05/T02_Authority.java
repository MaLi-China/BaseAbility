package OOP_Thinking.P05;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T02_Authority extends T01_Authority {
    public static void main(String[] args) {
        T02_Authority t = new T02_Authority();
        System.out.println(t.attribute_default);
        T01_Authority t2 = new T01_Authority();
        System.out.println(t2.attribute_default);
    }
}
