import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.List;


/**
 * run example : -p 1234
 * java -jar ./MCServer.jav -p [port]를 이용하려면
 * MCServer class를 test>java directory에서 main>java directory로 옮겨야합니다.
 */
public class MCServer {
    private static final int DEFAULT_PORT = 8080;
    private static final List<String> DEFAULT_BLACKLIST = Arrays.asList("bad_user1", "bad_user2");

    public static void main(String[] args) {
        Options options = new Options();

        Option portOption = new Option("p", "port", true, "서비스 포트");
        portOption.setRequired(false);
        portOption.setType(Number.class);
        options.addOption(portOption);

        Option blacklistOption = new Option("b", "blacklist", true, "블랙리스트");
        blacklistOption.setRequired(false);
        blacklistOption.setType(String.class);
        options.addOption(blacklistOption);

        Option helpOption = new Option("h", "help", false, "도움말");
        helpOption.setRequired(false);
        options.addOption(helpOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        int port = DEFAULT_PORT;
        List<String> blacklist = DEFAULT_BLACKLIST;

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("help")) {
                formatter.printHelp("Server", options);
                System.exit(0);
            }

            if (cmd.hasOption("port")) {
                port = ((Number) cmd.getParsedOptionValue("port")).intValue();
            }

            if (cmd.hasOption("blacklist")) {
                String[] blockedUsers = cmd.getOptionValue("blacklist").split(",");
                blacklist = Arrays.asList(blockedUsers);
            }

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Server", options);
            System.exit(1);
        }

        Server server = new Server(port, blacklist);
        server.start();
    }
}
