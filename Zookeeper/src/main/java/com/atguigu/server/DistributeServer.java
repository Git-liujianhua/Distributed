package com.atguigu.server;

import org.apache.zookeeper.*;

import java.io.IOException;

public class DistributeServer {

    private String connectString = "192.168.174.188:2181,192.168.174.188:2182,192.168.174.188:2183";
    private int sessionTimeout = 2000;
    private ZooKeeper zkCli;

    public static void main(String[] args) throws Exception {

        DistributeServer server = new DistributeServer();
        //1、连接Zookeeper集群
        server.getConnect();

        //2、注册节点
        server.regist(args[0]);

        //3、业务逻辑处理
        server.business();
    }

    private void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

    private void regist(String hostName) throws KeeperException, InterruptedException {
        //-e：暂时的服务器一下线，节点就取消
        //-s：写死的路径不能重复要覆盖，加上编号自动维护保证不重复
        String path = zkCli.create("/servers/server", hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostName +" is online");
    }

    private void getConnect() throws IOException {

        zkCli = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }
}
