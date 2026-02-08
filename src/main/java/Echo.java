import java.util.Scanner;

import a9527.task.*;
import a9527.a9527.A9527;
import a9527.ui.Ui;
import a9527.parser.Parser;
import a9527.command.Command;

public class Echo {

    public static void test() {
        String input;

        Scanner in = new Scanner(System.in);
        while(true) {
            input = in.nextLine();
            Command cmd = Parser.parse(input);
            cmd.execute();
        }
    }

}
