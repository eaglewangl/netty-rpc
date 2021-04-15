package com.netty.rpc.server.service.impl;

import com.netty.rpc.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello " + name + "!";
    }
}
