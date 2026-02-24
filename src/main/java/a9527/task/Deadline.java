package a9527.task;

import a9527.date.Date;

import java.time.LocalTime;

public class Deadline extends Task{
    //protected String by;
    private Date by;

    public Deadline(String description, String by) {
        super(description);
        this.by = new Date(by);
    }

    public Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = new Date(by);
    }

    public void setBy(String by) {
        this.by = new Date(by);
    }

    public Date getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.toString() + ")";
    }

    @Override
    public String toStorageFormat() {
        return "D | " + super.toStorageFormat() + " | " + by.toString();
    }
}
