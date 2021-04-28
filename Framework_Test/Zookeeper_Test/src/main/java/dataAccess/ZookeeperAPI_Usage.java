package dataAccess;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 功能说明：ZookeeperAPI使用
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/28
 */
public class ZookeeperAPI_Usage implements Watcher {
    private static final String hostList = "127.0.0.1:2181";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static Stat stat = new Stat();
    private static ZooKeeper zooKeeper;

    /**
     * 创建会话
     */
    @Before
    public void createSession() {
        try {
            zooKeeper = new ZooKeeper(hostList, 5000, this);
            System.out.println("state:" + zooKeeper.getState());
            countDownLatch.await();
            System.out.println("Zookeeper Session 创建完成.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建节点
     *
     * @throws InterruptedException
     * @throws KeeperException
     */
    @Test
    public void createZNode() throws InterruptedException, KeeperException {
        String path1 = zooKeeper.create("/ZookeeperAPI_Usage_create_", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Success create znode:" + path1);
        String path2 = zooKeeper.create("/ZookeeperAPI_Usage_create_", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("Success create znode:" + path2);
        zooKeeper.close();
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Receive WatchedEvent：" + event);
        try {
            if (Event.KeeperState.SyncConnected == event.getState()) {
                System.out.println("通知：会话连接成功");
                if (Event.EventType.None == event.getType() && null == event.getPath()) {
                    System.out.println("进入会话初始状态");
                    // 释放所有等待的线程
                    countDownLatch.countDown();
                } else if (event.getType() == Event.EventType.NodeCreated) {
                    System.out.println("节点创建通知：" + event.getPath());
                    zooKeeper.exists(event.getPath(), true);
                } else if (event.getType() == Event.EventType.NodeDataChanged) {
                    System.out.println("节点的数据变更通知：" + new String(zooKeeper.getData(event.getPath(), true, stat)));
                    System.out.println("czxid=" + stat.getCzxid() + "，mzxid=" + stat.getMzxid() + "，version=" + stat.getVersion());
                    zooKeeper.exists(event.getPath(), true);
                } else if (event.getType() == Event.EventType.NodeChildrenChanged) {
                    System.out.println("子节点的数据变更通知：" + zooKeeper.getChildren(event.getPath(), true));
                    zooKeeper.exists(event.getPath(), true);
                } else if (event.getType() == Event.EventType.NodeDeleted) {
                    System.out.println("节点删除通知：" + event.getPath());
                    zooKeeper.exists(event.getPath(), true);
                } else {
                    System.out.println("未知事件通知类型：" + event.getType());
                    zooKeeper.exists(event.getPath(), true);
                }
            } else if (Event.KeeperState.Disconnected == event.getState()) {
                System.out.println("通知：会话连接失败");
            } else if (Event.KeeperState.AuthFailed == event.getState()) {
                System.out.println("通知：会话认证失败");
            } else if (Event.KeeperState.Expired == event.getState()) {
                System.out.println("通知：会话过期");
            } else {
                System.out.println("未知的通知状态：" + event.getState());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
