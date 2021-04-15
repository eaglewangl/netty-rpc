package com.netty.rpc.server.service.bootstrap;

import com.netty.rpc.server.service.NettyServer;

public class ServerBootStrap {

    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1", 9000);
    }
}
