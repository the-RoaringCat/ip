package a9527.task;
import a9527.a9527.A9527;
public class Deadline extends Task{
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public static String[] parseArgument(String args) {
        //TODO: deal with certain argument being missing
        String[] parsed = new String[2];
        parsed[0] = A9527.extractBefore(args, " /by ").trim(); //description
        parsed[1] = A9527.extractAfter(args, " /by ").trim(); //by
        return parsed;
    }
}
