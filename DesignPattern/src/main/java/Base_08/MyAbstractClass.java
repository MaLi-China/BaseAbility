package Base_08;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class MyAbstractClass {
    public MyAbstractClass() {
        this.doSomething();
    }

    public void doSomething() {
        throw new RuntimeException("该方法必须被覆盖, 否则异常抛出!");
    }

    static class Template extends MyAbstractClass {
        public Template() {
            System.out.println("不使用父类的构造方法...");
        }

        public Template(String name) {
            System.out.println("Self Definition");
        }

        @Override
        public void doSomething() {
            //super.doSomething();
            System.out.println("Running...");
        }
    }

    public static void main(String[] args) {
        Template template = new Template("xxx");

    }
}


