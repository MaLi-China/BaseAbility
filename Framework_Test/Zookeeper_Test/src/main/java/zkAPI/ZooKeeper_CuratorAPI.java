package zkAPI;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * 功能说明：Curator对zookeeper进行了封装, 更方便的操作zookeeper
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/1
 */
public class ZooKeeper_CuratorAPI {

    private static ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3, 3000);
    public static final CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", 3000, 1000, retryPolicy);

    @Before
    public void init() {
        client.start();
    }

    /**
     * 测试CuratorAPI
     *
     * @throws Exception 异常
     */
    @Test
    public void testCase() throws Exception {
        //1. 创建数据 路径必须是从根目录开始，以/打头
        client.create().forPath("/a");
        //2. 创建一个有内容的b节点（只能创建一层节点）
        client.create().forPath("/b", "hello curator".getBytes(StandardCharsets.UTF_8));
        //3. 创建持久节点，同时创建多层节点, 有需要则创建多层目录
        client.create().creatingParentsIfNeeded().forPath("/x/y/z", "".getBytes(StandardCharsets.UTF_8));
        //4. 创建带有的序号的持久节点, PERSISTENT_SEQUENTIAL:带序号的 -s
        client.create().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/path", "data".getBytes(StandardCharsets.UTF_8));
        //5. 创建临时节点（客户端关闭，节点消失），设置延时5秒关闭（Thread.sleep(5000)）
        //...
        //6. 创建临时带序号节点（客户端关闭，节点消失），设置延时5秒关闭（Thread.sleep(5000)）
        //...
        // 关闭客户端
        client.close();
    }

    @Test
    public void testNodeCache() {

        try {
            //1, 创建节点监听对象
            NodeCache node_api = new NodeCache(client, "/node_api");
            //2, 开始缓存
            node_api.start(true);
            //3, 添加监听对象
            node_api.getListenable().addListener(new NodeCacheListener() {
                @Override
                public void nodeChanged() throws Exception {
                    byte[] data = node_api.getCurrentData().getData();
                    System.out.println("data: " + new String(data));
                }
            });
//            System.in.read();
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPathChildrenCache() {
        PathChildrenCache cache = new PathChildrenCache(client, "/node_api", true);
        //启动时缓存子节点数据
        try {
            cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
