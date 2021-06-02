package chapter5_5_Future;

/**
 * 功能说明：Future模式的关键, 实际上是RealData的代理, 封装了获取RealData的等待过程
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/28
 */
public class FutureData implements Data {
    protected RealData realData = null;
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();// 通知正在等待的getResult
    }


    @Override
    public synchronized String getResult() {
        while (!isReady) {
            try {
                wait();//等待RealData被注入
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getResult();
    }
}
