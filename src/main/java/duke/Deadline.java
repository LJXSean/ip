package duke;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * A type of task that stores a date and time
 *
 * @author Sean Lam
 */
public class Deadline extends Task {
    protected String type = "[D]";
    protected LocalDate date;
    protected LocalTime time;

    /**
     * Constructor of Deadline
     *
     * @param description Description of task
     * @param date Date of deadline
     * @param time Time of deadline
     */
    Deadline(String description, String date, String time) {
        super(description);
        this.date = LocalDate.parse(date);
        this.time = LocalTime.parse(time);
    }

    /**
     * Returns string representation of Deadline task for display in TaskList
     *
     * @return Deadline task string
     */
    @Override
    public String toString() {
        return type + super.toString() + " (by: " + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ", "
                + time.format(DateTimeFormatter.ofPattern("hhmma")) + ")";
    }

    /**
     * Returns string representation of Deadline task to be stored in dukeHistory
     *
     * @return Deadline task string
     */
    @Override
    public String toFile() {
        String isDone = "0";
        if (super.isDone) {
            isDone = "1";
        }
        return String.format("D|%s|%s|%s|%s\n", isDone, super.description, date, time);
    }
}
