package test_websocket;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/TestServer")
public class WebSocket{
    //notice:not thread-safe
    private static ArrayList<Session> sessionList = new ArrayList<Session>();

    //Session確立 ハンドシェイクするらしい
    @OnOpen
    public void onOpen(Session session){
        try{
            sessionList.add(session);
            //asynchronous communication
            session.getBasicRemote().sendText("Hello!");
        }catch(IOException e){}
    }

    @OnClose
    public void onClose(Session session){
        sessionList.remove(session);
    }

    @OnMessage
    public void onMessage(String msg){
        try{
            for(Session session : sessionList){
                //asynchronous communication
                session.getBasicRemote().sendText(msg);
            }
        }catch(IOException e){}
    }
}