package mchapter05;

/**
 * 功能说明：Test the WeakReference
 * 开发人员：@Author MaLi
 */
public class T02_WeakReference {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("GC is working...");
    }

    public static void main(String[] args) {
        T02_WeakReference object = new T02_WeakReference();
        object = null;
        System.gc();
        System.out.println("GC start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
