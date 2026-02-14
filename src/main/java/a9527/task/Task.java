package a9527.task;

public class Task {


    protected String description;
    protected boolean isDone;

    public Task(String description, boolean isDone){
        this.description = description;
        this.isDone = isDone;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + (isDone? "X" : " ") + "] " + description;
    }

    public String toStorageFormat() {
        return ((isDone ? "true" : "false") + " | " + description);
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markDone() {
        this.isDone = true;
    }
    public void markNotDone() {
        this.isDone = false;
    }
}
