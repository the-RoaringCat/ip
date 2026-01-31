import java.util.Scanner;

public class Echo {

    public static void echoUser() {
        String msg;
        String[] msgs;

        Scanner in = new Scanner(System.in);

        boolean toQuit = false;

        while(!toQuit) {
            //polling for input
            msg = in.nextLine();
            msgs = msg.split(" ");
            //TODO: msgs length when needed

            switch (msgs[0]) {//test if just a newline char
                case "bye"-> {
                    A9527.byeUser();
                    toQuit = true;
                }

                case "list" -> {
                    A9527.printWithLines(Task::printTasks);
                }

                case "mark" -> {
                    //TODO: Add error for invalid index
                    int finalTaskIndex = Integer.parseInt(msgs[1]);
                    A9527.printWithLines(() -> {
                        Task.markTasksMsg();
                        Task.markTasks(finalTaskIndex);
                        Task.printTask(finalTaskIndex);
                    });
                }
                case "unmark" -> {
                    //TODO: Add error for invalid index
                    int finalTaskIndex = Integer.parseInt(msgs[1]);
                    A9527.printWithLines(() -> {
                        Task.unmarkTasksMsg();
                        Task.unmarkTasks(finalTaskIndex);
                        Task.printTask(finalTaskIndex);
                    });
                }
                default -> {
                    String finalMsg = msg;
                    A9527.printWithLines(() -> {
                        System.out.println("\tadded: " + finalMsg);
                        Task.addTask(finalMsg);
                    });
                }
            }

        }
    }

}
