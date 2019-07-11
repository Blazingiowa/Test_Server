package test_websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/WebSocketServer")
public class WebSocket
{

	@OnOpen
    public void onOpen(Session session) {
        /* セッション確立時の処理 */
		System.out.println(session.getId() + " was connected.");
    }

    @OnMessage
    public void onMessage(String message) {
        /* メッセージ受信時の処理 */
        System.out.println("WebSocket受信：" + message);
    }

    @OnError
    public void onError(Throwable th) {
        /* エラー発生時の処理 */
        System.out.println("WebSocketエラー：" + th.getMessage());
    }

    @OnClose
    public void onClose(Session session) {
        /* セッション解放時の処理 */
        System.out.println("WebSocketセッション確立");
    }
}
