package DP07_Observer.Evolution02;

/**
 * 功能说明：使用观察者
 * 开发人员：@author MaLi
 */
public class MainDemo {
    static class Child {
        private boolean isCry = false;
        private Dad dad;

        public Child(Dad dad) {
            this.dad = dad;
        }

        public void cry() {
            this.isCry = true;
            System.out.println("Baby is crying...");
            dad.appease(this);
            System.out.println("Baby crying?" + isCry);
        }
    }

    static class Dad {
        public void appease(Child child) {
            System.out.println("dad is appeasing...");
            child.isCry = false;
        }
    }

    public static void main(String[] args) {
        Dad dad = new Dad();
        Child child = new Child(dad);
        child.cry();
    }
}
