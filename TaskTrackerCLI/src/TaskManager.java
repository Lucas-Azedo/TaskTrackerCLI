import java.util.ArrayList;

public class TaskManager{
    private int nextId = 1;
    ArrayList<Task> tasks = new ArrayList<>();

    public void add(String name) {
        Task task = new Task(nextId++, name, false);
        tasks.add(task);
        System.out.println("Task added successfully (ID: " + task.id + ")");
    }
}
