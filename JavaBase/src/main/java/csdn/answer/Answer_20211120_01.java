package csdn.answer;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Answer_20211120_01 {
    /*volatile*/ boolean flag = true;

    void test() {
        System.out.println("start");
        while (flag) {
            //System.out.println(".");
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        Answer_20211120_01 problemDemo = new Answer_20211120_01();
        new Thread(problemDemo::test).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------");
        problemDemo.flag = false;
        System.out.println("-----------");
    }
}
