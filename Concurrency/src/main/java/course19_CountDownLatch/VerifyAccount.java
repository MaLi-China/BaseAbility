package course19_CountDownLatch;

/**
 * 功能说明：模拟商品订单与物流订单的对账系统
 * 1, 查询商品订单库, 找出未对账订单;
 * 2, 查询物流订单库, 找到商品订单对应的物流订单;
 * 3, check二者, 如果商品订单未发货, 或者重复发货, 保存数据到异常库
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/10
 */
public class VerifyAccount {
    //版本1: 串行执行
    public void verifyAccountV1() {
        Result pOrders = getPOrders();
        Result dOrders = getDOrders();
        Object diff = check(pOrders, dOrders);
        save(diff);
    }

    Result pOrders;
    Result dOrders;

    //版本2: 查订单库与查派单库并行执行
    public void verifyAccountV2() {
        Thread getPOrdersThread = new Thread(() -> pOrders = getPOrders());
        Thread getDOrdersThread = new Thread(() -> dOrders = getDOrders());
        getPOrdersThread.start();
        getDOrdersThread.start();
        try {
            getPOrdersThread.join();
            getDOrdersThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object diff = check(pOrders, dOrders);
        save(diff);
    }


    //查询未对账订单
    public Result getPOrders() {
        //省略业务代码...
        return null;
    }

    //查询物流派送订单
    public Result getDOrders() {
        //省略业务代码...
        return null;
    }

    //执行对账操作
    public Object check(Result pos, Result dos) {
        //省略业务代码...
        return null;
    }

    //差异写入差异库
    public int save(Object diff) {
        //省略业务代码...
        return 0;
    }

}

/**
 * 模拟查询数据库结果
 */
class Result {
}
