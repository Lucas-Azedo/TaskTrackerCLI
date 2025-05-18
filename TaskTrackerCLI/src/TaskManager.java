import java.util.ArrayList;

public class TaskManager{
    private int nextId = 1;
    ArrayList<Task> tasks = new ArrayList<>();

    public void add(String name) {
        String status = "todo";

        Task task = new Task(nextId++, name, status);
        tasks.add(task);
        System.out.println("Task added successfully (ID: " + task.id + ")");
    }

    public void update(int Id, String Name){
        boolean found = false;

        for(Task i : tasks){
            if(i.getId() == Id){
                i.setDescription(Name);
                i.setUpdatedAt();

                System.out.println("Task updated successfully");

                found = true;
                break;
            }

        }

        if(!found){
        System.out.println("Task not found");
        }
    }

    public void delete(int Id){
        boolean found = false;

        for(Task i : tasks){
            if(i.getId() == Id){
                tasks.remove(i);
                System.out.println("Task deleted successfully");

                found = true;
                break;
            }

        }

        if(!found){
            System.out.println("Task not found");
        }
    }

    public void list(){
        for(Task i : tasks){
            System.out.println("ID: " + i.getId() + "| Name: " + i.getDescription() + "| Status: " + i.getStatus() + "Last Updated: "+ i.getUpdatedAt() + "| Created:" + i.getCreatedAt());
        }
    }

    public void markProgress(int Id){
        boolean found = false;

        for(Task i : tasks){
            if(i.getId() == Id){
                i.setStatus("in progress");
                System.out.println("Task set to: in progress");
                i.setUpdatedAt();

                found = true;
                break;
            }
        }
    if(!found){
            System.out.println("Task not found");
        }
    }

    public void markDone(int Id){
        boolean found = false;

        for(Task i : tasks){
            if(i.getId() == Id){
                i.setStatus("done");
                System.out.println("Task set to: done");
                i.setUpdatedAt();

                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Task not found");
        }
    }

    public void listByStatus(String status){
        for(Task i : tasks){
            if(status.equals(i.getStatus())) {
                System.out.println("ID: " + i.getId() + "| Name: " + i.getDescription());
            }
        }
    }
}
