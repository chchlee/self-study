import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String clientId;
    private final Map<String, Socket> clients;

    public ClientHandler(Socket socket, Map<String, Socket> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.out = new PrintWriter(this.socket.getOutputStream(), true);

            String message = this.in.readLine();

            if (message != null && message.startsWith("@connect")) {
                this.clientId = message.split(" ")[1];
                clients.put(clientId, socket);

                System.out.println("새로운 클라이언트 접속: " + this.clientId);
                this.out.println("서버접속, " + this.clientId + "!");

                while (true) {
                    message = this.in.readLine();

                    if (message != null) {
                        JSONObject jsonMessage = new JSONObject(message);
                        String senderId = jsonMessage.getString("sender");
                        String receiverId = jsonMessage.getString("receiver");
                        String content = jsonMessage.getString("content");

                        if (senderId.equals(clientId)) {
                            if (clients.containsKey(receiverId)) {
                                Socket receiverSocket = clients.get(receiverId);
                                PrintWriter receiverOut = new PrintWriter(receiverSocket.getOutputStream(), true);
                                receiverOut.println("@" + clientId + " " + content);
                            } else {
                                this.out.println("User " + receiverId + " not found.");
                            }
                        }
                    } else {
                        break;
                    }
                }

                clients.remove(clientId);
                System.out.println("Client disconnected: " + this.clientId);

            } else {
                this.out.println("접속이 필요합니다.");
            }

            this.socket.close();

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
