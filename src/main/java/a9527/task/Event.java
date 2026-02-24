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

    public void setStart(String start) {
        this.start = new Date(start);
    }

    public void setEnd(String end) {
        this.end = new Date (end);
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start.toString() + " to: " + end.toString() + ")";
    }

    @Override
    public String toStorageFormat() {
        return "E | " + super.toStorageFormat() + " | " + start.toString() + " | " + end.toString();
    }
}
