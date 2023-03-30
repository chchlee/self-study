import java.util.Arrays;

public class Handler {


    void handleMessage(String message) {
        String[] tokens = message.split(" ");
        String command = tokens[0];

        switch (command) {
            case "message":
                handleChatMessage(tokens);
                break;
            case "userlist":
                handleUserList(tokens);
                break;
            case "time":
                handleTime(tokens);
                break;
            case "accesstime":
                handleAccessTime(tokens);
                break;
            default:
                System.out.println("Unknown command");
        }
    }

    void handleChatMessage(String[] tokens) {
        String senderUserId = tokens[1];
        String chatMessage = String.join(" ", Arrays.copyOfRange(tokens, 2, tokens.length));
        System.out.println("#" + senderUserId + " " + chatMessage);
    }

    void handleUserList(String[] tokens) {
        String userList = String.join(", ", Arrays.copyOfRange(tokens, 1, tokens.length));
        System.out.println("접속유저: " + userList);
    }

    void handleTime(String[] tokens) {
        String time = tokens[1];
        System.out.println("#@ time " + time);
    }

    void handleAccessTime(String[] tokens) {
        String accessTime = tokens[1];
        System.out.println("사용시간: " + accessTime);
    }
}