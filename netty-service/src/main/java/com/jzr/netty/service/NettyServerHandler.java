package com.jzr.netty.service;

import com.jzr.mybatis.model.Device;
import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.NettyChannelMap;
import com.jzr.netty.protocol.*;
import com.jzr.netty.utils.TestUtils;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;

import java.util.Date;


public class NettyServerHandler extends SimpleChannelInboundHandler<BaseMsg> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //channel失效，从Map中移除
        int i = NettyChannelMap.remove((SocketChannel) ctx.channel());
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {

        switch (baseMsg.getType()) {
            case REGISTER: // 注册

                break;

            case PING:

                PingMsg reqPingMsg = (PingMsg) baseMsg;
                String ip = reqPingMsg.getIp();
                Device devices = TestUtils.selectByPrimaryIp(ip);
                Device device = new Device();

                device.setAppVersion(reqPingMsg.getAppVersion());
                device.setDeviceIp(reqPingMsg.getIp());
                device.setDeviceMac(((PingMsg) baseMsg).getMacIp());
                device.setDeviceNo(reqPingMsg.getClientId());
                device.setDeviceType(reqPingMsg.getEquipmentType());
                device.setNurseboardIp(reqPingMsg.getNurseboardIp());
                device.setLastUpTime(new Date());

                if (devices == null) {
                    TestUtils.insertSelective(device);
                } else {
                    TestUtils.updateByPrimarykey(device);
                }

                if (NettyChannelMap.get(baseMsg.getIp()) == null) {
                    NettyChannelMap.add(baseMsg.getIp(), (SocketChannel) channelHandlerContext.channel());
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
                voiceResponse.setIp(voiceRequest.getIp());
                voiceResponse.setEquipmentType(voiceRequest.getEquipmentType());
                voiceResponse.setBedInfo(voiceRequest.getBedInfo());

                if (NettyChannelMap.get(voiceRequest.getNurseCeardIp()) != null) {
                    NettyChannelMap.get(voiceRequest.getNurseCeardIp()).writeAndFlush(voiceResponse);//回写数据给client端
                }
            }

            break;

            //取消语音协议
            case CANCEL_VOICE: {
                CancelVoiceRequest cancelVoiceRequest = (CancelVoiceRequest) baseMsg;
                CancelVoiceResponse cancelVoiceResponse = new CancelVoiceResponse();
                cancelVoiceResponse.setIp(cancelVoiceRequest.getIp());
                cancelVoiceResponse.setClientId(cancelVoiceRequest.getClientId());
                cancelVoiceResponse.setEquipmentType(cancelVoiceRequest.getEquipmentType());
                if (NettyChannelMap.get(cancelVoiceRequest.getCancelIp()) != null) {
                    NettyChannelMap.get(cancelVoiceRequest.getCancelIp()).writeAndFlush(cancelVoiceResponse);
                }
            }
            break;

            //视频
            case VIDEO: {
                VideoRequest videoRequest = (VideoRequest) baseMsg;
                VideoResponse videoResponse = new VideoResponse();

                videoResponse.setClientId(videoRequest.getClientId());
                videoResponse.setEquipmentType(videoRequest.getEquipmentType());

                NettyChannelMap.get(videoRequest.getClientId()).writeAndFlush(videoRequest);
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
                NettyChannelMap.get(cancelVideoRequest.getClientId()).writeAndFlush(cancelVideoRequest);
                //回复请求者
                channelHandlerContext.writeAndFlush(cancelVideoResponse);
            }
            break;

            default:
                System.out.println("default");
                break;
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