import java.util.Scanner;

import a9527.task.*;
import a9527.a9527.A9527;
import a9527.parser.Parser;
import a9527.command.Command;
import a9527.ui.Ui;

public class Echo {

    public static void test() {
        String input;

        Scanner in = new Scanner(System.in);
        while(!A9527.shouldExit()) {
            input = in.nextLine();
            try {
                Command cmd = Parser.parse(input);
                cmd.execute();
            } catch (Exception e) {
                Ui.print(e.getMessage());
            }
        }
        String homo = """
                 　      .▃▆█▇▄▖
                　　 　▟◤▖　　　◥█▎
                　　　◢◤　 ▐　　　　▐▉
                　▗◤　　　▂　▗▖　　▕█▎
                　◤　▗▅▖◥▄　▀◣　　█▊
                ▐　▕▎◥▖◣◤　　　　◢██
                █◣　◥▅█▀　　　　▐██◤
                ▐█▙▂　　　 ◢██◤
                　◥██◣　　　　◢▄◤
                　　　▀██▅▇▀""";

        System.out.println(homo);

    }

}


