import java.io.*;
import java.net.*;

class Snc {

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Usage: snc [option] [hostname] [port]");
            System.out.println("Options:");
            System.out.println("-l <port>    run in server mode, listen to the given port");
            return;
        }

        String mode = args[0];
        String hostname = null;
        int port = 0;

        if (mode.equals("-l")) { // server mode
            port = Integer.parseInt(args[1]);
            startServer(port);
        } else { // client mode
            hostname = args[0];
            port = Integer.parseInt(args[1]);
            startClient(hostname, port);
        }
    }

    private static void startServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client connection on port " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            Thread readThread = new Thread(() -> {
                try {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Client: " + inputLine);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading from client: " + e.getMessage());
                }
            });

            readThread.start();

            Thread writeThread = new Thread(() -> {
                try {
                    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
                    String inputLine;
                    while ((inputLine = stdin.readLine()) != null) {
                        out.write(inputLine + "\n");
                        out.flush();
                    }
                } catch (IOException e) {
                    System.err.println("Error writing to client: " + e.getMessage());
                }
            });

            writeThread.start();

            // Wait for threads to finish
            try {
                readThread.join();
                writeThread.join();
            } catch (InterruptedException e) {
                System.err.println("Interrupted while waiting for threads: " + e.getMessage());
            }

            // Close sockets and streams
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

            System.out.println("Connection closed");
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

    private static void startClient(String hostname, int port) {
        try {
            Socket socket = new Socket(hostname, port);
            System.out.println("Connected to server " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            Thread readThread = new Thread(() -> {
                try {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Server: " + inputLine);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading from server: " + e.getMessage());
                }
            });

            readThread.start();

            Thread writeThread = new Thread(() -> {
                try {
                    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in                ));
                String inputLine;
                while ((inputLine = stdin.readLine()) != null) {
                    out.write(inputLine + "\n");
                    out.flush();
                }
            } catch (IOException e) {
                System.err.println("Error writing to server: " + e.getMessage());
            }
        });

        writeThread.start();

        // Wait for threads to finish
        try {
            readThread.join();
            writeThread.join();
        } catch (InterruptedException e) {
            System.err.println("Interrupted while waiting for threads: " + e.getMessage());
        }

        // Close sockets and streams
        in.close();
        out.close();
        socket.close();

        System.out.println("Connection closed");
    } catch (IOException e) {
        System.err.println("Error connecting to server: " + e.getMessage());
    }
}

