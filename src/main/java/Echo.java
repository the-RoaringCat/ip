import java.util.Scanner;

public class Echo {

    public static void echoUser() {
        String msg;
        String[] msgs;
        int taskIndex = 0;
        Scanner in = new Scanner(System.in);

        boolean toQuit = false;

        while(!toQuit) {
            //polling for input
            msg = in.nextLine();
            msgs = msg.split(" ");
            switch (msgs[0]) {//test if just a newline char
                case "bye":
                    A9527.byeUser();
                    toQuit = true;
                    break;
                case "list":
                    System.out.println(A9527.LINE);
                    Task.printTasks();
                    System.out.println(A9527.LINE);
                    break;
                case "mark":
                    taskIndex = Integer.parseInt(msgs[1]);
                    System.out.println(A9527.LINE + "\tNice! I've marked this task as done:");
                    Task.markTasks(taskIndex);
                    Task.printTask(taskIndex);
                    System.out.println(A9527.LINE);
                    break;
                case "unmark":
                    taskIndex = Integer.parseInt(msgs[1]);
                    System.out.println(A9527.LINE + "\tOK, I've marked this task as not done yet:");
                    Task.unmarkTasks(taskIndex);
                    Task.printTask(taskIndex);
                    System.out.println(A9527.LINE);
                    break;
                default:
                    System.out.println(A9527.LINE);
                    System.out.println("\tadded: " + msg);
                    Task.addTask(msg);
                    System.out.println(A9527.LINE);
            }

        }
    }

}
