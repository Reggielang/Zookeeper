package zookeeper_case;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DistributeServer {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {


        DistributeServer server = new DistributeServer();
        server.getConnect();
        //1.链接到zookeeper集群

        //2.注册节点
        server.regist(args[0]);

        //3.业务逻辑
        server.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostname) throws KeeperException, InterruptedException {
        String path = zkClient.create("/servers/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname+" is online ");
    }

    private String connectString = "hadoop102:2181,hadoop103:2181,hadoop104:2181";
    private int sessionTimeout=2000;
    private ZooKeeper zkClient;
    void getConnect() throws IOException {
         zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }
}
