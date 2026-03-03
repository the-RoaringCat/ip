package a9527.task;

import a9527.date.Date;

public class Event extends Task{
    private Date start;
    private Date end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = new Date(start);
        this.end =  new Date(end);
    }

    public Event(String description, boolean isDone,  String start, String end) {
        super(description, isDone);
        this.start = new Date (start);
        this.end = new Date (end);
    }

    /**
     *
     * @return Returns a string representation of an event task
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start.toString() + " to: " + end.toString() + ")";
    }

    /**
     *
     * @return Returns a string representation of an event task for storage
     */
    @Override
    public String toStorageFormat() {
        return "E | " + super.toStorageFormat() + " | " + start.toString() + " | " + end.toString();
    }
}
