package com.netty.rpc.client.bootstrap;

import com.netty.rpc.client.NettyClient;
import com.netty.rpc.service.Constants;
import com.netty.rpc.service.HelloService;

public class ClientBootStrap {

    public static void main(String[] args) throws Exception {
        NettyClient client = new NettyClient();
        HelloService service = (HelloService) client.getBean(HelloService.class, Constants.NETTY_TEST_SERVICE_PROTOCOL);
        while (true){
            Thread.sleep(2 * 1000);
            String res = service.hello("xiao wang");
            System.out.println("res:--->" + res);
        }
    }
}
