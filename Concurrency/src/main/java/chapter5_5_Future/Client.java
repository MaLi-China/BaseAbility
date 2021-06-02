package chapter5_5_Future;

/**
 * 功能说明：模拟客户端程序, Client主要实现获取FutureData, 开启构造RealData的线程
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/28
 */
public class Client {

    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread() {
            public void run() {
                //这里创建很慢
                RealData realData = new RealData(queryStr);
                // 创建完, 封装到FutureData里面去
                future.setRealData(realData); // 内部会通知FutureData的正在wait的线程
            }
        }.start();

        return future;
    }

}
