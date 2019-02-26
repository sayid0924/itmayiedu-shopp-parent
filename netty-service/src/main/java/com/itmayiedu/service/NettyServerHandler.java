package com.itmayiedu.service;

import com.itmayiedu.base.BaseMsg;
import com.itmayiedu.base.MsgType;
import com.itmayiedu.base.NettyChannelMap;
import com.itmayiedu.protocol.*;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<BaseMsg> {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static final AtomicInteger onlineCount = new AtomicInteger(0);
    //    private boolean reduceOnlineCount = true;
    AtomicBoolean reduceOnlineCount = new AtomicBoolean(true);

    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //channel失效，从Map中移除
        int i = NettyChannelMap.remove((SocketChannel) ctx.channel());
        if (i > 0) {
            if (reduceOnlineCount.get()) {
                int cnt = onlineCount.decrementAndGet();  //在线数减1
                System.out.println("One connection is closed! Current number of online devices:" + cnt);
            }
        }
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
        ChannelFuture f = null;
        Connection conn = null;
        ResultSet rs = null;

        if (MsgType.REGISTER.equals(baseMsg.getType())) {
            RegisterRequest registerRequest = (RegisterRequest) baseMsg;
            RegisterResponse registerResponse = new RegisterResponse();
            registerResponse.setEquipmentType(registerRequest.getEquipmentType());
            registerResponse.setClientId(registerRequest.getClientId());

            //注册成功,把channel存到服务端的map中
            try {
                NettyChannelMap.add(baseMsg.getIp(), (SocketChannel) channelHandlerContext.channel());
                int cnt = onlineCount.incrementAndGet();   //在线数加1
                System.out.println("new connection! current Equipment count:" + cnt + " new Ip:" + baseMsg.getIp());
                registerResponse.setStatus(0);
            } catch (Exception ex) {
                registerResponse.setStatus(-1);
                ex.printStackTrace();
            }

            f = channelHandlerContext.writeAndFlush(registerResponse);   //回写数据给client端
            f.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    System.out.println("RegisterResponse to Client Success! Time:" + dateFormat.format(new Date()));
                } else {
                    System.out.println("RegisterResponse to Client Fail! Time:" + dateFormat.format(new Date()));
                }
                System.out.println("--------------------------------------------------");
            });
        }

        if (NettyChannelMap.get(baseMsg.getIp()) == null) {
            //说明未注册，或者连接断了，服务器向客户端发起登录请求，让客户端重新注册
            RegisterRequest registerRequest = new RegisterRequest();
            channelHandlerContext.channel().writeAndFlush(registerRequest);
            System.out.println("If the connection is not logged in, or the connection is broken, the server sends a login request to the client for the client to log in again.");
        }

        switch (baseMsg.getType()) {
            case PING: {
                PingMsg replyPing = new PingMsg();
//                f = NettyChannelMap.get(pingMsg.getClientId()).writeAndFlush(replyPing);   //回写数据给client端
                f = channelHandlerContext.writeAndFlush(replyPing);   //回写数据给client端
                f.addListener((ChannelFutureListener) future -> {
                    if (future.isSuccess()) {
//                  System.out.println("PingMsg to Client Success! Time:" +  baseMsg.getClientId() + "   " +baseMsg.getEquipmentType() +"   " + dateFormat.format(new Date()));
                    } else {
                        System.out.println("PingMsg to Client Fail! Time:" + dateFormat.format(new Date()));
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            break;

            //app应用程序升级协议
//            case UPGRADE: {
//                UpgradeRequest upgradeRequest = (UpgradeRequest) baseMsg;
//                UpgradeResponse upgradeResponse = new UpgradeResponse();
//
//                //1 = 代表自己，2=代表其他端来升级系统
//                Integer upgradeValue = upgradeRequest.getUpgradeMode() == null ? 1 : upgradeRequest.getUpgradeMode();
//                reduceOnlineCount.set(upgradeValue == 1 ? true : false);
//
//                //查找数据库是否有新版本更新，如果有就提示更新，否则不提示更新。成功返回更新的app升级包地址
//                upgradeResponse.setClientId(upgradeRequest.getClientId());
//                upgradeResponse.setEquipmentType(upgradeRequest.getEquipmentType());
//
//                conn = JDBCDataSource.getInstance().getConnection();
//                //查找数据库版本信息，如果有就写入，否则返回错误
//                String sql = "SELECT soft_name,full_version,version,folder_url from t_version where soft_type =? ORDER BY version desc LIMIT 1";
//                PreparedStatement statement = null;
//
//                try {
//                    statement = conn.prepareStatement(sql);
//                    statement.setString(1, upgradeRequest.getEquipmentType());
//
//                    rs = statement.executeQuery();
//                    while (rs.next()) {
//                        String f1 = rs.getString("soft_name").trim();
//                        String f2 = rs.getString("full_version").trim();
//                        String f3 = rs.getString("folder_url").trim();
//                        String f4 = rs.getString("version").trim();
//
//                        upgradeResponse.setAppPath(f3);
//                        upgradeResponse.setVersion(Integer.parseInt(f4));
//                        upgradeResponse.setStatus(0);
//                        System.out.println(f3 + " " + f2 + "  " + f1 + " " + f4);
//                        break;
//                    }
//                } catch (SQLException e) {
//                    upgradeResponse.setStatus(-1);
//                    e.printStackTrace();
//                } finally {
//                    JDBCUtils.release(rs, statement, conn);
//                }
//
//                f = NettyChannelMap.get(upgradeRequest.getClientId()).writeAndFlush(upgradeResponse);   //回写数据给client端
//                f.addListener((ChannelFutureListener) future -> {
//                    if (future.isSuccess()) {
//                        System.out.println("UpgradeResponse to Client Success! Time:" + dateFormat.format(new Date()));
//                    } else {
//                        System.out.println("UpgradeResponse to Client Fail! Time:" + dateFormat.format(new Date()));
//                    }
//                    System.out.println("--------------------------------------------------");
//                });
//            }
//            break;

            //语音协议
            case VOICE: {
                VoiceRequest voiceRequest = (VoiceRequest) baseMsg;
                VoiceResponse voiceResponse = new VoiceResponse();
                voiceResponse.setClientId(voiceRequest.getClientId());
                voiceRequest.setIp(voiceRequest.getIp());
                voiceResponse.setEquipmentType(voiceRequest.getEquipmentType());
                voiceResponse.setBedInfo(voiceRequest.getBedInfo());

                if(NettyChannelMap.get(voiceRequest.getNurseCeardIp())!=null) {
                    System.out.println( "getNurseCeardIp:     " +voiceRequest.getNurseCeardIp() +   "      "  + dateFormat.format(new Date()));
                    NettyChannelMap.get(voiceRequest.getNurseCeardIp()).writeAndFlush(voiceResponse);
                }

//                f = NettyChannelMap.get(voiceRequest.getClientId()).writeAndFlush(voiceRequest);  //回写数据给client端
//                f.addListener((ChannelFutureListener) future -> {
//                    if (future.isSuccess()) {
//                        voiceResponse.setStatus(0);
//                        System.out.println("Forward voice to Client Success! Time:" + dateFormat.format(new Date()));
//                    } else {
//                        voiceResponse.setStatus(-1);
//                        System.out.println("Forward voice to Client Fail! Time:" + dateFormat.format(new Date()));
//                    }
//                    System.out.println("--------------------------------------------------");
//                });

                //回复请求者
//                channelHandlerContext.writeAndFlush(voiceResponse);

            }
            break;

            //取消语音协议
            case CANCEL_VOICE: {
                CancelVoiceRequest cancelVoiceRequest = (CancelVoiceRequest) baseMsg;
                CancelVoiceResponse cancelVoiceResponse = new CancelVoiceResponse();
                cancelVoiceResponse.setIp(cancelVoiceRequest.getIp());
                cancelVoiceResponse.setClientId(cancelVoiceRequest.getClientId());
                cancelVoiceResponse.setEquipmentType(cancelVoiceRequest.getEquipmentType());

                if(NettyChannelMap.get(cancelVoiceRequest.getNurseCeardIp())!=null){
                    System.out.println( "cancelVoiceRequest:     " +cancelVoiceRequest.getNurseCeardIp() +   "      "  + dateFormat.format(new Date()));
                    NettyChannelMap.get(cancelVoiceRequest.getNurseCeardIp()).writeAndFlush(cancelVoiceResponse);
                }

//                f = NettyChannelMap.get(cancelVoiceRequest.getClientId()).writeAndFlush(cancelVoiceRequest);
//                f.addListener((ChannelFutureListener) future -> {
//                    if (future.isSuccess()) {
//                        cancelVoiceResponse.setStatus(0);
//                        System.out.println("CancelVoiceResponse to Client Success! Time:" + dateFormat.format(new Date()));
//                    } else {
//                        cancelVoiceResponse.setStatus(-1);
//                        System.out.println("CancelVoiceResponse to Client Fail! Time:" + dateFormat.format(new Date()));
//                    }
//                    System.out.println("--------------------------------------------------");
//                });

                //回复请求者
//                channelHandlerContext.writeAndFlush(cancelVoiceResponse);
            }
            break;

            //视频
            case VIDEO: {
                VideoRequest videoRequest = (VideoRequest) baseMsg;
                VideoResponse videoResponse = new VideoResponse();

                videoResponse.setClientId(videoRequest.getClientId());
                videoResponse.setEquipmentType(videoRequest.getEquipmentType());

                f = NettyChannelMap.get(videoRequest.getClientId()).writeAndFlush(videoRequest);
                f.addListener((ChannelFutureListener) future -> {
                    if (future.isSuccess()) {
                        videoResponse.setStatus(0);
                        System.out.println("Forward video to Client Success! Time:" + dateFormat.format(new Date()));
                    } else {
                        videoResponse.setStatus(-1);
                        System.out.println("Forward video to Client Fail! Time:" + dateFormat.format(new Date()));
                    }
                    System.out.println("--------------------------------------------------");
                });

                //回复请求者
                channelHandlerContext.writeAndFlush(videoResponse);
            }
            break;

            //取消视频
            case CANCEL_VIDEO: {
                CancelVideoRequest cancelVideoRequest = (CancelVideoRequest) baseMsg;
                CancelVideoResponse cancelVideoResponse = new CancelVideoResponse();

                cancelVideoResponse.setClientId(cancelVideoRequest.getClientId());
                cancelVideoResponse.setEquipmentType(cancelVideoRequest.getEquipmentType());

                f = NettyChannelMap.get(cancelVideoRequest.getClientId()).writeAndFlush(cancelVideoRequest);
                f.addListener((ChannelFutureListener) future -> {
                    if (future.isSuccess()) {
                        cancelVideoResponse.setStatus(0);
                        System.out.println("CancelVideoResponse to Client Success! Time:" + dateFormat.format(new Date()));
                    } else {
                        cancelVideoResponse.setStatus(-1);
                        System.out.println("CancelVideoResponse to Client Fail! Time:" + dateFormat.format(new Date()));
                    }
                    System.out.println("--------------------------------------------------");
                });

                //回复请求者
                channelHandlerContext.writeAndFlush(cancelVideoResponse);
            }
            break;

            default:
                System.out.println("default");
                break;
        }
        if (conn != null) {
            conn.close();
        }
        ReferenceCountUtil.release(baseMsg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        closeOnFlush(ctx.channel());  // 发生异常，关闭链路
    }

    static void closeOnFlush(Channel ch) {
        if (ch.isActive()) {
            ch.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
    }
}