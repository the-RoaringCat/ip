import java.util.Scanner;

public class Echo {

    public static void echoUser() {
        String msg;
        Scanner in = new Scanner(System.in);
        boolean toQuit = false;

        while(!toQuit) {
            //polling for input
            msg = in.nextLine();
            switch (msg) {
                case "bye":
                    A9527.byeUser();
                    toQuit = true;
                    break;
                case "list":
                    A9527.printTask();
                    break;
                default:
                    System.out.println(A9527.LINE);
                    System.out.println("\tadded: " + msg);
                    A9527.addTask(msg);
                    System.out.println(A9527.LINE);
            }

        }
    }

}
