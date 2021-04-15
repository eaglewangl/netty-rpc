package com.netty.rpc.client.handler;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelHandlerAdapter implements Callable {

    private ChannelHandlerContext ctx;
    private String result;
    private String param;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public synchronized Object call() throws Exception {
        System.out.println("call 调用");
        ctx.writeAndFlush(param);
        wait();
        System.out.println("call2 被调用");
        return result;
    }

    public void setParam(String param){
        this.param = param;
    }
}
