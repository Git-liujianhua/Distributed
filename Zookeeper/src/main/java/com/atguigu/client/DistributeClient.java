package com.atguigu.client;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DistributeClient {

    private String connectString = "192.168.174.188:2181,192.168.174.188:2182,192.168.174.188:2183";
    private int sessionTimeout = 2000;
    private ZooKeeper cli;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

        DistributeClient client = new DistributeClient();

        //连接Zookeeper集群
        client.getConnect();
        //注册监听
        client.getChlidren();
        //逻辑代码
        client.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getChlidren() throws KeeperException, InterruptedException {
        //获取servers路劲下的所有节点
        List<String> children = cli.getChildren("/servers", true);
        //存储服务器节点主机名称创建一个集合
        ArrayList<String> hosts = new ArrayList<>();
        for (String child : children) {
            byte[] data = cli.getData("/servers/" + child, false, null);
            hosts.add(new String(data));
        }
        //将所有在线主机名称打印到控制台上
        System.out.println(hosts);
    }

    private void getConnect() throws IOException {

        cli = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    getChlidren();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
