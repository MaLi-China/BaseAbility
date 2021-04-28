package dataAccess;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author MaLi
 */
public class Demo1 {

    @Test
    public void testGetData() throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 1000, (WatchedEvent event) ->
                System.out.println("-->" + event.toString())
        );
        byte[] data = zooKeeper.getData("/node", false, null);
        System.out.println(new String(data));
        data = zooKeeper.getData("/node", (WatchedEvent event) ->
                        System.out.println("-->" + event.toString())
                , null);
        System.out.println(new String(data));
    }
}
