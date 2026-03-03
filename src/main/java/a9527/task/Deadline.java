package a9527.task;

import a9527.date.Date;

import java.time.LocalTime;

public class Deadline extends Task{
    private Date by;


    public Deadline(String description, String by) {
        super(description);
        this.by = new Date(by);
    }

    public Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = new Date(by);
    }

    /**
     *
     * @return Returns a string representation of a deadline task
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.toString() + ")";
    }

    /**
     *
     * @return Returns a string representation of a deadline task for storage
     */
    @Override
    public String toStorageFormat() {
        return "D | " + super.toStorageFormat() + " | " + by.toString();
    }
}
