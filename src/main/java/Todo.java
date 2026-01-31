public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }


    public static void addTask(String description) {
        tasks[taskCount] = new Todo(description);
        taskCount ++;
    }
}
