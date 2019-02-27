package com.jzr.netty.base;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class NettyChannelMap {
    public static Map<String, SocketChannel> map = new ConcurrentHashMap<>();

    public static void add(String ip, SocketChannel socketChannel) {
        map.put(ip, socketChannel);
    }

    public static SocketChannel get(String ip) {
        if (map == null || map.size() == 0) {
            return null;
        }
        return map.get(ip);
    }

    public static int remove(SocketChannel socketChannel) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == socketChannel) {
                System.out.println("remove channel:" + entry.getKey().toString());
                map.remove(entry.getKey());
                return 1;
            }
        }
        return 0;
    }
}