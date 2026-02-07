package a9527.task;
public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public static String[] parseArgument(String args) {
        String[] parsed = new String[1];
        parsed[0] = args; //description
        return parsed;
    }
}
