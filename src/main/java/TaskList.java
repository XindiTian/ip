import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TaskList {

    public TaskList() {}

    public static void createTask(String input, Scanner sc) {
        ArrayList<Task> lst = new ArrayList<>();
        Storage store = new Storage();
        String home = store.getHome();
        String file = store.defaultFilePath();
        if (input.equals("list")) {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < lst.size(); i++) {
                int count = i + 1;
                Task a = lst.get(i);
                System.out.println(count + ". " + a);
            }
            System.out.println();
        } else if (input.equals("done")) {
            int tag = sc.nextInt() - 1;
            Task d = lst.get(tag);
            d.markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(d + "\n");

            String temp = home + File.separator + "temp.txt";
            //create temp file
            File tempf = new File(temp);
            //copy contents of old file to temp file
            try {
                Files.copy(Paths.get(file), Paths.get(temp));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //delete contents of old file
            try {
                new FileWriter(file, false).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner sf = null;
            try {
                sf = new Scanner(tempf);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < lst.size(); i++) {
                Task t = lst.get(i);
                if (i != tag) {
                    try {
                        store.appendToFile(file, sf.nextLine() + "\n");
                    } catch (IOException e){
                        System.out.println("OOPS!!! " + e.getMessage());
                    }
                } else {
                    try {
                        t.markAsDone();
                        Storage.appendToFile(file, "(DONE)" + sf.nextLine() + "\n");
                    } catch (IOException e){
                        System.out.println("OOPS!!! " + e.getMessage());
                    }
                }
            }
            //delete temp file
            try {
                Files.delete(Paths.get(temp));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (input.equals("delete")) {
            int tag = sc.nextInt() - 1;
            int len = lst.size() - 1;
            System.out.println("Noted. I've removed this task:");
            System.out.println("\t" + lst.get(tag));
            System.out.println("Now you have " + len + " tasks in the list.\n");

            String temp = home + File.separator + "temp.txt";
            //create temp file
            File tempf = new File(temp);
            //copy contents of old file to temp file
            try {
                Files.copy(Paths.get(file), Paths.get(temp));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //delete contents of old file
            try {
                new FileWriter(file, false).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner sf = null;
            try {
                sf = new Scanner(tempf);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <= len; i++) {
                if (i != tag) {
                    try {
                        Storage.appendToFile(file,  sf.nextLine() + "\n");
                    } catch (IOException e){
                        System.out.println("OOPS!!! " + e.getMessage());
                    }
                }
            }
            //delete temp file
            try {
                Files.delete(Paths.get(temp));
            } catch (IOException e) {
                e.printStackTrace();
            }
            lst.remove(tag);
        } else if (input.equals("todo")) {
            String task = sc.nextLine();
            try {
                Todo td = Todo.makeTodo(task);
                lst.add(td);
                int len = lst.size();
                System.out.println("Got it. I've added this task:");
                System.out.println("\t" + td);
                System.out.println("Now you have " + len + " tasks in the list.\n");
                try {
                    Storage.appendToFile(file, "Todo:" + " 0" + task + "\n");
                } catch (IOException e) {
                    System.out.println("OOPS!!! " + e.getMessage());
                }
            } catch (DukeException ex){
                System.err.println("☹ OOPS!!! The description of a todo cannot be empty.\n");
            }
        } else if (input.equals("deadline")) {
            String line = sc.nextLine();
            try {
                Deadline dl = Deadline.makeDeadline(line);
                lst.add(dl);
                int len = lst.size();
                System.out.println("Got it. I've added this task:");
                System.out.println("\t" + dl);
                System.out.println("Now you have " + len + " tasks in the list.\n");
                try {
                    Storage.appendToFile(file,  "Deadline:" + " 0"+ line + "\n");
                } catch (IOException e) {
                    System.out.println("OOPS!!! " + e.getMessage());
                }
            } catch (DukeException ex){
                System.err.println("☹ OOPS!!! The description of a deadline cannot be empty.\n");
            }
        } else if (input.equals("event")) {
            String line = sc.nextLine();
            try {
                Event event = Event.makeEvent(line);
                lst.add(event);
                int len = lst.size();
                System.out.println("Got it. I've added this task:");
                System.out.println("\t" + event);
                System.out.println("Now you have " + len + " tasks in the list.");
                try {
                    Storage.writeToFile(file, "Event:" + " 0" + line + "\n");
                } catch (IOException e) {
                    System.out.println("OOPS!!! " + e.getMessage());
                }
            } catch (DukeException ex){
                System.err.println("☹ OOPS!!! The description of an event cannot be empty.\n");
            }
        } else {
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
        }
    }
}
