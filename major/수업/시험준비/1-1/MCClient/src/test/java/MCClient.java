import org.apache.commons.cli.ParseException;

public class MCClient {
    public static void main(String[] args) {
        try {
            ChatClient client = new ChatClient(args);
            client.start();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}