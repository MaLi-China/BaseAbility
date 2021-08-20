package syntax.method;

/**
 * 功能说明：测试方法引用
 * 开发人员：@Author MaLi
 */
public class Demo {
    public static void main(String[] args) {
        User user = new User();
        Thread t1 = new Thread(user::show, "T1");
        Thread t2 = new Thread(user::dosomthing, "T2");
        t1.start();
        t2.start();
        System.out.println("Main Thread...");
    }

    static class User {
        public void show() {
            System.out.println("show method");
        }

        public void dosomthing() {
            System.out.println("dosomthing method");
        }
    }

}


