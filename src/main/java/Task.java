public class Task {


    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public static String[] parseArgument(String args) {
        String[] parsed = new String[1];
        parsed[0] = args;
        return parsed;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public String getStatusIcon() {
        return (isDone? "X" : " ");
    }
    public String getDescription() {
        return this.description;
    }


    public void markDone() {
        this.isDone = true;
    }
    public void markNotDone() {
        this.isDone = false;
    }
}
