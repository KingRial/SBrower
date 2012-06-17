import org.webbitserver.WebSocketConnection;
import org.webbitserver.WebSocketHandler;
import netscape.javascript.JSObject;

public class WebSocket implements WebSocketHandler {
  boolean debug=false;
  private int connectionCount;
  String javaScriptPrefix="";
  JSObject jso;
  @Override
  public void onOpen(WebSocketConnection connection) {
	  String message="OPEN: Ci sono altre "+connectionCount+" connessioni";
	  Log(message);
	  connection.send(message);
	  connectionCount++;
  }
  @Override
  public void onClose(WebSocketConnection connection) {
	  connectionCount--;
	  String message="CLOSE: Ci sono altre "+connectionCount+" connessioni";
	  Log(message);
  }
  @Override
  public void onMessage(WebSocketConnection connection, String message) {
	  Log("MESSAGE: \""+message+"\"; There are " + connectionCount + " other connections active");
      Object[] params={connection,message};
      callJavascript(javaScriptPrefix+"onMessage",params);
  }
  @Override
  public void onPong(WebSocketConnection connection, String message){
	  Log("PONG: \""+message+"\" There are " + connectionCount + " other connections active");  
  }
  @Override
  public void onMessage(WebSocketConnection arg0, byte[] arg1) throws Throwable {
	  //Log("Message2");
  }
  
  public void sendMessageTo(WebSocketConnection connection, String message){
	  connection.send(message);
  }
  
  public void callJavascript(String method,Object[] args){
	  try {
          jso.call(method,args);
      }
      catch (Exception ex) {
          ex.printStackTrace();
      }
  }
  
  private void Log(String message){
		if(debug)System.out.println(message);
  }
}