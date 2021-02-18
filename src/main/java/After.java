public class After extends Task {
    protected String cond;

    /**
     * Constructor for the task of type After.
     * @param des task to be done.
     * @param cond condition that serves as the check before the task can be mark as done.
     */
    public After(String des, String cond) {
        super(des);
        this.cond = cond;
    }

    /**
     * checks if the input contains the keyword "after" which is the trigger to create an After task.
     * @param input string that the user inputs.
     * @return true if input contains after, else outputs false.
     */
    public static boolean haveAfter(String input) {
        String[] line = input.split("after");
        return line.length != 1;
    }

    /**
     * Creates a task which will be marked as done when the condition has been satisfied.
     * @param input a String which contains the tasks to add.
     * @return an Object of type After, which contains the 2 tasks specified in the input.
     */
    public static After makeAfter(String input) {
        String[] line = input.split("after");
        String des = line[0];
        String cond = line[1];
        return new After(des, cond);
    }

    @Override
    public String toString() {
        return "[A]" + super.toString() + " (after: " + cond + ")";
    }
}
