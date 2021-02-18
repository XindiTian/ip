public class Task {
    protected String des;
    protected boolean status;

    /**
     * Constructor for the Object Task.
     * @param des A string containing the description of the task.
     */
    public Task(String des) {
        this.des = des;
        this.status = false;
    }

    /**
     * checks if the status is marked as done or not
     * @return if status is done, return [X], else return [ ]
     */
    public String getStatus() {
        return (status ? "[X]" : "[ ]");
    }

    /**
     * sets status to true if called
     */

    public void markAsDone() {
        status = true;
    }

    public String toString() {
        return this.getStatus() + " " + des;
    }
}
