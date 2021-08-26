package course14.test_03_unsynch;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：测试异步调用
 * 开发人员：@Author MaLi
 */
public class T01_UnSync {
    // 异步调用
    public int longMethod() {
        int result = 10;
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("异步方法执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }


    //异步方法
    public Result longMethod2() {
        Result result = new Result();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                result.setContent("Hello UnSynch");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();
        return result;
    }


    public static void main(String[] args) {
        T01_UnSync instance = new T01_UnSync();
        //对方法进行异步调用
        /*Thread thread = new Thread(instance::longMethod);
        thread.start();
        System.out.println("Main method executed completely!");*/

        Result result = instance.longMethod2();
        System.out.println("Get result right now: " + result.getContent());
        try {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("Get result after 4S: " + result.getContent());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    class Result {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
