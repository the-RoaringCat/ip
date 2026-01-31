import java.util.Arrays;
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
            //TODO: what if multiple spaces btw certain words
            msgs = msg.split(" ");
            //TODO: msgs length when needed

            switch (msgs[0]) {//test if just a newline char
                case "bye"-> {
                    A9527.byeUser();
                    toQuit = true;
                }

                case "list" -> A9527.printWithLines(Task::printTasks);

                case "todo" -> {
                    String finalDescription = String.join(" ", Arrays.copyOfRange(msgs, 1, msgs.length));
                    A9527.printAddTask(() -> {
                        Todo.addTask(finalDescription);
                    });
                }

                case "deadline" -> {
                    //TODO: deal with /by being missing
                    String[] parts = msg.split(" /by ", 2);
                    String finalDescription = parts[0].replaceFirst("^deadline ", "").trim();
                    String finalBy = parts[1].trim();
                    A9527.printAddTask(() -> {
                        Deadline.addTask(finalDescription, finalBy);
                    });
                }

                case "event" -> {
                    String args = msg.replaceFirst("^event ", "").trim();
                    String finalDescription = A9527.extractBefore(args, " /from ").trim();
                    String finalStart = A9527.extractBetween(args, " /from ", " /to ").trim();
                    String finalEnd = A9527.extractAfter(args, " /to ").trim();
                    A9527.printAddTask(() -> {
                        Event.addTask(finalDescription, finalStart, finalEnd);
                    });
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
