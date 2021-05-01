package zkAPI;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 功能说明：ZooKeeper API测试使用
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/1
 */
public class ZooKeeperAPI {
    public static final String LOCALHOST_2181 = "localhost:2181";
    private static final int SESSIONTIMEOUT = 60000;
    private ZooKeeper zooKeeper = null;
    //1. 创建一个空节点(a)（只能创建一层节点）
    //2. 创建一个有内容的b节点（只能创建一层节点）
    //3. 创建持久节点，同时创建多层节点
    //4. 创建带有的序号的持久节点
    //5. 创建临时节点（客户端关闭，节点消失），设置延时5秒关闭（Thread.sleep(5000)）
    //6. 创建临时带序号节点（客户端关闭，节点消失），设置延时5秒关闭（Thread.sleep(5000)）

    @Before
    public void init() {
        try {

            zooKeeper = new ZooKeeper(LOCALHOST_2181, SESSIONTIMEOUT, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println("do noting watcher ...");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建临时znode
     */
    @Test
    public void testMethod1() {
        try {
            String s = zooKeeper.create("/node_api1", "hello zookeeper".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("return data: " + s);
            Thread.sleep(100000);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("-----------------");
        }
    }

    /**
     * 测试获取节点值, 修改节点值
     */
    @Test
    public void testMethod2() {
        try {
            zooKeeper.create("/node_api", "永久节点".getBytes("utf-8"), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            byte[] data = zooKeeper.getData("/node_api", false, null);
            System.out.println(new String(data));
            Stat stat = zooKeeper.setData("/node_api", "修改节点值".getBytes(StandardCharsets.UTF_8), 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试案例
     */
    @Test
    public void testAllCase() {
        try {
            //1. 创建一个空节点(a)（只能创建一层节点）
            String a = zooKeeper.create("/a", null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            //2. 创建一个有内容的b节点（只能创建一层节点）
            zooKeeper.create("/b", "".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            //3. 创建持久节点，同时创建多层节点
            zooKeeper.create("/x/y/z", "xyz".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //4. 创建带有的序号的持久节点
            zooKeeper.create("/node_sorted", "sorted znode".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            //5. 创建临时节点（客户端关闭，节点消失），设置延时5秒关闭（Thread.sleep(5000)）
            zooKeeper.create("/ephemeral", "".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            //6. 创建临时带序号节点（客户端关闭，节点消失），设置延时5秒关闭（Thread.sleep(5000)）
            zooKeeper.create("/ephemeral", "".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            Thread.sleep(5000);

            //删除操作
            zooKeeper.delete("/x/y/z", 0);
            Stat exists = zooKeeper.exists("/x/y/z", false);
            System.out.println("/x/y/z节点是否已删除" + exists);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                zooKeeper.close();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    /**
     * 测试zookeeper的watcher机制
     */
    public void testWatcher() {
        //TODO - Watch机制
    }
}
