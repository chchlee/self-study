import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.commons.cli.*;


/**
 * run exmaple : -H localhost -h 8080 -I user1
 * java -jar ./MCServer.jav -p [port]를 이용하려면
 *  * MCClient class를 test>java directory에서 main>java directory로 옮기고 *.jar
 *  파일을 생성해야 합니다.
 */

public class ChatClient {
    private final Handler handler = new Handler();
    private String serverClient;
    private int serverPort;
    private String userId;
    private String targetUserId = "all";

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ChatClient(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("H", "host", true, "접속할 서버의 호스트 네임 또는 IP를 지정합니다.");
        options.addOption("p", "port", true, "접속할 서버의 서비스 포트를 지정합니다.");
        options.addOption("I", "userid", true, "채팅에서 사용할 사용자 아이디를 지정합니다.");
        options.addOption("h", "help", false, "도움말 출력");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("help")) {
            printHelp(options);
            System.exit(0);
        }

        if (cmd.hasOption("host")) {
            serverClient = cmd.getOptionValue("host");
        } else {
            printHelp(options);
            System.exit(1);
        }

        if (cmd.hasOption("port")) {
            serverPort = Integer.parseInt(cmd.getOptionValue("port"));
        } else {
            printHelp(options);
            System.exit(1);
        }

        if (cmd.hasOption("userid")) {
            userId = cmd.getOptionValue("userid");
        } else {
            printHelp(options);
            System.exit(1);
        }
    }

    private void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("ChatClient", options);
    }

    public void start() {
        try {
            socket = new Socket(serverClient, serverPort);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println("connect " + userId);

            Thread readThread = new Thread(() -> {
                try {
                    while (true) {
                        String message = reader.readLine();
                        if (message != null) {
                            handler.handleMessage(message);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readThread.start();

            Thread inputThread = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    String message = scanner.nextLine();

                    if (message.startsWith("@")) {
                        int index = message.indexOf(' ');

                        if (index != -1) {
                            targetUserId = message.substring(1, index);
                            message = message.substring(index + 1);
                        } else {
                            targetUserId = "all";
                            message = message.substring(1);
                        }

                        writer.println(targetUserId + " " + message);
                    } else {
                        writer.println(targetUserId + " " + message);
                    }
                }
            });
            inputThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}