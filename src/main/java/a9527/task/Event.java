package a9527.task;
import a9527.a9527.A9527;
public class Event extends Task{
    String start;
    String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start + " to: " + end + ")";
    }

    public static String [] parseArgument(String args) {
        //TODO: deal with certain argument being missing
        String[] parsed = new String[3];
        parsed[0] = A9527.extractBefore(args, " /from ").trim(); //description
        parsed[1] = A9527.extractBetween(args, " /from ", " /to ").trim(); //start
        parsed[2] = A9527.extractAfter(args, " /to ").trim(); //end
        return parsed;
    }
}
