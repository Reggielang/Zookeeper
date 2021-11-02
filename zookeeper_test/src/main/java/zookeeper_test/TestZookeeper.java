package zookeeper_test;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestZookeeper {
    //zookeeper客户端访问集群的端口号
    private String connectString="hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;

    @Before
    public void init() throws IOException {
         zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    //创建子节点
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String path = zkClient.create("/honelang", "wozuishuai".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);


    }


}
