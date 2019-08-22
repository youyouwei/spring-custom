package com.feiyang.interviewdemo.websocketDemo;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * @description:
 * java websocket client
 * @author: jhyang
 * @create: 2019-06-26 10:36
 **/
public class WebsocketDemo {

    public static void main(String[] args) {
        try {

            String url = "wss://localhost:15017/refer/oddsPoints/awardBroadcast";
            URI uri = new URI(url);
            WebSocketClient wsc = new WebSocketClient(uri) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {

                }

                @Override
                public void onMessage(String message) {
                    System.out.println(message);

                }

                @Override
                public void onClose(int code, String reason, boolean remote) {

                }

                @Override
                public void onError(Exception ex) {

                }
            };
            wsc.connect();
            System.out.println("websocket connect");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
