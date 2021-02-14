import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDateTime at;

    public Event(String des, LocalDateTime at) {
        super(des);
        this.at = at;
    }

    /**
     * makes an event with the string given.
     * @param line input string that will be split into the task description and date.
     * @return an Event.
     * @throws DukeException
     */

    public static Event makeEvent(String line) throws DukeException {
        if (line.equals("")) {
            throw new DukeException("☹ OOPS!!!The description of a todo cannot be empty.\n");
        } else {
            String[] split = line.split("/at ");
            String task = split[0];
            String[] temp = split[1].split(" ");
            String date = temp[0];
            LocalTime time = LocalTime.parse(temp[1]);
            LocalDate d = LocalDate.parse(date);
            LocalDateTime dt = d.atTime(time);
            return new Event(task, dt);
        }
    }


    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + at.format(DateTimeFormatter.ofPattern("MMM d yyyy, ha")) + ")";
    }
}
