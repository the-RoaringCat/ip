import java.util.Scanner;

public class Echo {

    public static void echoUser() {
        String msg;
        String[] msgs;

        Scanner in = new Scanner(System.in);

        boolean toQuit = false;

        //polling for input
        while(!toQuit) {
            Task newTask = null;
            msg = in.nextLine();
            //TODO: what if multiple spaces btw certain words；Update: I guess I can ignore this if I still use extract method from A9527
            msgs = msg.split(" ");
            //TODO: msgs length when needed
            //TODO: deal with the case there are unexpected input after single word command

            switch (msgs[0]) {//test if just a newline char
                case "bye"-> {
                    A9527.byeUser();
                    toQuit = true;
                }

                case "list" -> A9527.printWithinLines(TaskList::printTaskList);

                case "todo" -> {
                    String[] todoAttribute = Todo.parseArgument(A9527.extractAfter(msg, "todo "));
                    newTask = new Todo(todoAttribute[0]);
                }

                case "deadline" -> {
                    String[] deadlineAttribute = Deadline.parseArgument(A9527.extractAfter(msg, "deadline "));
                    newTask = new Deadline(deadlineAttribute[0], deadlineAttribute[1]);
                }

                case "event" -> {
                    String[] eventAttribute = Event.parseArgument(A9527.extractAfter(msg, "event "));
                    newTask = new Event(eventAttribute[0], eventAttribute[1], eventAttribute[2]);
                }
                case "mark" -> {
                    //TODO: Add error for invalid index
                    int finalTaskIndex = Integer.parseInt(msgs[1]);
                    A9527.printWithinLines(() -> TaskList.printAndMark(finalTaskIndex));
                }
                case "unmark" -> {
                    //TODO: Add error for invalid index
                    int finalTaskIndex = Integer.parseInt(msgs[1]);
                    A9527.printWithinLines(() -> TaskList.printAddUnmark(finalTaskIndex));
                }

                case "congrat" -> A9527.printWithinLines(() -> System.out.println("\tCongratulate for being congratulated by limbei"));
                default -> newTask = new Task(msg);
            }

            if(newTask != null) {
                TaskList.addToTaskList(newTask);
                A9527.printAddTask(newTask);
            }
        }
    }
}
