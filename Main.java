import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
  public static void main(String[] args)
      throws Exception {
    String p = System.getenv("PORT");
    int port = 8080;
    if (p != null) {
      port = Integer.parseInt(p);
    }
    HttpServer server = HttpServer.create(
      new InetSocketAddress(port), 0);
    server.createContext("/", ex -> {
      byte[] b = "Hello Render".getBytes();
      ex.sendResponseHeaders(200, b.length);
      ex.getResponseBody().write(b);
      ex.close();
    });
    server.start();
  }
}