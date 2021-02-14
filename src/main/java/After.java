public class After extends Task {
    protected String cond;

    public After(String des, String cond) {
        super(des);
        this.cond = cond;
    }

    public static boolean haveAfter(String input) {
        String[] line = input.split("after");
        return line.length != 1;
    }

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
