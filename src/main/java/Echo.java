import java.util.Scanner;

public class Echo {

    public static void echoUser() {
        String msg;
        Scanner in = new Scanner(System.in);

        while(true) {
            //polling for input
            msg = in.nextLine();
            if(msg.equals("bye")) {
                A9527.byeUser();
                break;
            } else {
                System.out.println(A9527.LINE);
                System.out.println("\t" + msg);
                System.out.println(A9527.LINE);
            }
        }
    }

}
