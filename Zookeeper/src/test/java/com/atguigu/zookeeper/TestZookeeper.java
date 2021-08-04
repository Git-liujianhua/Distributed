package com.atguigu.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestZookeeper {

    private String connectString = "192.168.174.188:2181,192.168.174.188:2182,192.168.174.188:2183";
    private int sessionTimeOut = 2000;
    ZooKeeper zkCli;

    //Ctrl+p：查看方法形参、参数
    //Ctrl+q：查看类、方法、属性注释

    /**
     * 创建客户端
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        zkCli = new ZooKeeper(connectString, sessionTimeOut, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
            //     System.out.println("-----start------");
            //     List<String> children = null;
            //     try {
            //         children = zkCli.getChildren("/", true);
            //         for (String child : children){
            //             System.out.println(child);
            //         }
            //     } catch (Exception e) {
            //         e.printStackTrace();
            //     }
            //     System.out.println("-----end------");
                try {
                    Stat stat = zkCli.exists("/meinv", true);
                    System.out.println(stat==null?"not exist":"exist="+stat);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 创建子节点
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        String path = zkCli.create("/meinv", "jingjing".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    /**
     * 获取子节点并监听节点变化
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void getDataAndWatch() throws KeeperException, InterruptedException {
        List<String> children = zkCli.getChildren("/", true);
        for (String child : children){
            System.out.println(child);
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     * 判断Znode是否存在
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void exist() throws KeeperException, InterruptedException {
        Stat stat = zkCli.exists("/meinv", false);
        System.out.println(stat==null?"not exist":"exist="+stat);
        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     * 删除节点以及数据
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void deleteZnode() throws KeeperException, InterruptedException {
        zkCli.delete("/meinv",0);
    }
}
