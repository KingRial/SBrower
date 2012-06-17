import java.applet.Applet;
import java.io.IOException;

import netscape.javascript.JSObject;

import org.webbitserver.*;

public class server extends Applet { 
	/**
	 * 
	 */
	private static final long serialVersionUID = -3442289025125812266L;
	private boolean debug=true;
	private int serverPort=8080;
	private String javaScriptPrefix="";
	WebServer webServer;
	WebSocket webSocket;

	/**
	 * @param args
	 */
	public void init() 
    {
		//Initialization variables
		serverPort=(this.getParameter("port")==null?8080:Integer.parseInt(this.getParameter("port")));
		debug=(this.getParameter("debug")==null?false:((Integer.parseInt(this.getParameter("debug")))==1));
		javaScriptPrefix=(this.getParameter("javaScriptPrefix")==null?"":this.getParameter("javaScriptPrefix"));
		
		Log("Starting local websocket on port:"+serverPort);
		webSocket=new WebSocket();
		webSocket.debug=debug;
		webSocket.javaScriptPrefix=javaScriptPrefix;
		Log("Using call Javascript Prefix:"+javaScriptPrefix);
		
		try {
			webSocket.jso=JSObject.getWindow(this);
		} finally{
			try {
				webServer = WebServers.createWebServer(serverPort)
				  .add("/websocket", webSocket)
				  .start();
				Log("Server running at " + webServer.getUri());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop() 
    {
		Log("Server stopped.");
		try {
			webServer.stop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public void sendMessageTo(WebSocketConnection connection, String message){
		webSocket.sendMessageTo(connection,message);
	}
	
	private void Log(String message){
		if(debug)System.out.println(message);
	}
}
