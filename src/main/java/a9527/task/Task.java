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

    /**
     *
     * @return Returns a string representation of a task
     */
    @Override
    public String toString() {
        return "[" + (isDone? "X" : " ") + "] " + description;
    }

    /**
     *
     * @return Returns a string representation of a task for storage
     */
    public String toStorageFormat() {
        return ((isDone ? "true" : "false") + " | " + description);
    }


    /**
     *
     * @param description a string
     * @return Returns true if the task description matches the input description.
     */
    public boolean isContain(String description) {
        return this.description.contains(description);
    }

    /**
     * Marks the task as done
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done
     */
    public void markNotDone() {
        this.isDone = false;
    }
}
