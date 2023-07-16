package com.lc.crush.chat.server.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author abing
 * @date 2023/6/15 16:30
 */
@Slf4j
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    /**
     * 当web客户端连接后，触发该方法
     * @author lc
     * @date 2023/6/15 16:34
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端连接成功");
    }

    /**
     * 客户端离线
     * @author lc
     * @date 2023/6/15 16:37
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端离线");
    }

    /**
     * 可能出现业务判断离线后再次触发，取消绑定
     * @author lc
     * @date 2023/6/15 16:38
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        // 可能出现业务判断离线后再次触发 channelInactive
        log.info("触发 channelInactive 掉线![{}]", ctx.channel().id());
    }

    /**
     * 心跳检查
     * @author lc
     * @date 2023/6/15 16:38
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.info("心跳：");
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            // 读空闲
            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                // 关闭用户的连接
            }
        } else if (evt == WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE) {
        }
        super.userEventTriggered(ctx, evt);
    }

    /**
     * 处理异常
     * @author lc
     * @date 2023/6/15 16:39
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("异常发生，异常消息: {}", cause.getMessage());
        ctx.channel().close();
    }

    /**
     * 读取消息
     * @author lc
     * @date 2023/6/15 16:37
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        log.info("读取到的消息：{}", msg.text());
    }
}
