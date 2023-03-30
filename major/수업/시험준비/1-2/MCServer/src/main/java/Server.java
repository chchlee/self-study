import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    private final int port;
    private final List<String> blacklist;
    private final Map<String, Socket> clients;

    public Server(int port, List<String> blacklist) {
        this.port = port;
        this.blacklist = blacklist;
        this.clients = new HashMap<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(this.port)) {
            System.out.println("Server started on port " + this.port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private final Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private String clientId;

        public ClientHandler(Socket socket) {
            this.socket = socket;
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

                    System.out.println("New client connected: " + this.clientId);
                    this.out.println("Welcome to the server, " + this.clientId + "!");

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
                    System.out.println("클라이언 접속 종료: " + this.clientId);

                } else {
                    this.out.println("접속이 필요합니다.");
                }

                this.socket.close();

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
