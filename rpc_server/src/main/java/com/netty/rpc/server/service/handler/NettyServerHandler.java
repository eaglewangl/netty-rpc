package com.netty.rpc.server.service.handler;

import com.netty.rpc.server.service.impl.HelloServiceImpl;
import com.netty.rpc.service.Constants;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class NettyServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("msg:--->" + msg);
        String msgStr = msg.toString();
        if (msgStr.startsWith(Constants.NETTY_TEST_SERVICE_PROTOCOL)){
            String result = new HelloServiceImpl().hello(msgStr.substring(msgStr.lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
