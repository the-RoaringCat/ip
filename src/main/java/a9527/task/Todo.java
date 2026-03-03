package a9527.task;
public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     *
     * @return Returns a string representation of a todo task
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     *
     * @return Returns a string representation of a todo task for storage
     */
    @Override
    public String toStorageFormat() {
        return "T | " + super.toStorageFormat();
    }
}
