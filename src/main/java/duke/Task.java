package duke;

/**
 * Represents a task
 *
 * @author Sean Lam
 */
abstract public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for Task
     *
     * @param description Description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void setStatusIcon(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return '[' + getStatusIcon() + "] " + description;
    }

    public void updateStatus() {
        String acknowledgement;
        if (isDone) {
            acknowledgement = "Nice! I've marked this task as done:\n\t" + this;
        } else {
            acknowledgement= "OK, I've marked this task as not done yet:\n\t" + this;
        }
        System.out.println(acknowledgement);
    }

    public abstract String toFile();
}
