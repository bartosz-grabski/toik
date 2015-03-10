package pl.edu.agh;

import java.util.Date;

import javax.inject.Named;

import org.springframework.format.datetime.joda.MillisecondInstantPrinter;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Named
public class WebSocketHandler extends TextWebSocketHandler {
	
	private UpdateTimeThread thread;

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		System.out.println(session.getRemoteAddress());
		this.thread = new UpdateTimeThread(session);
		this.thread.start();
		super.afterConnectionEstablished(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		System.out.println(message.getPayload());
		TextMessage msg = new TextMessage("Server time: " + new Date());
		session.sendMessage(msg);
		super.handleTextMessage(session, message);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		this.thread.terminate();
		super.afterConnectionClosed(session, status);
	}
	
	private class UpdateTimeThread extends Thread {
		
		private WebSocketSession session;
		private boolean run;
		
		public UpdateTimeThread(WebSocketSession session) {
			this.session = session;
			
		}
		
		@Override
		public void run() {
			this.run = true;
			while(run) {
				try {
					TextMessage msg = new TextMessage("Server time: " + new Date());
					session.sendMessage(msg);
					Thread.sleep(1000L);
				} catch (Exception e) {
					System.err.print(e);
				}
			}
		}
		
		public void terminate() {
			this.run = false;
		}
	}
}
