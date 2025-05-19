import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class TaskManager {
    private int nextId = 1;
    ArrayList<Task> tasks = new ArrayList<>();

    public void saveToFile(Task task) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("tasks.txt", true));
            bw.write(task.getId() + ";" + task.getDescription() + ";" + task.getStatus());
            bw.newLine();

        } catch (Exception e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    public void saveAll(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tasks.txt"))) {
            for (Task task : tasks) {
                bw.write(task.getId() + ";" + task.getDescription() + ";" + task.getStatus());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Erro ao sobrescrever arquivo: " + e.getMessage());
        }
    }

    public void loadFromFile(){
        int maxId = 0;

        try{
            String line = "";

            BufferedReader br = new BufferedReader(new FileReader("tasks.txt"));

            while((line = br.readLine()) != null){
                String[] parts = line.split(";");

                if(parts.length >= 3) {
                    int id = Integer.parseInt(parts[0]);
                    String description = parts[1];
                    String status = parts[2];

                    if (id > maxId) {
                        maxId = id;}

                    Task task = new Task(id, description, status);
                    tasks.add(task);
                }
            }
            nextId = maxId + 1;
        }
        catch(Exception e){
            System.out.println("Erro ao carregar tarefas: " + e.getMessage());
        }
    }

    public void add(String name) {
        loadFromFile();

        String status = "todo";

        Task task = new Task(nextId++, name, status);
        tasks.add(task);
        saveAll();
        System.out.println("Task added successfully (ID: " + task.id + ")");
    }

    public void update(int Id, String Name){
        loadFromFile();
        boolean found = false;

        for(Task i : tasks){
            if(i.getId() == Id){
                i.setDescription(Name);
                i.setUpdatedAt();

                System.out.println("Task updated successfully");
                saveAll();

                found = true;
                break;
            }

        }

        if(!found){
        System.out.println("Task not found");
        }
    }

    public void delete(int Id){
        loadFromFile();
        boolean found = false;

        for(Task i : tasks){
            if(i.getId() == Id){
                tasks.remove(i);
                System.out.println("Task deleted successfully");
                saveAll();

                found = true;
                break;
            }

        }

        if(!found){
            System.out.println("Task not found");
        }
    }

    public void list(){
        loadFromFile();
        for(Task i : tasks){
            System.out.println("ID: " + i.getId() + "| Name: " + i.getDescription() + "| Status: " + i.getStatus() + "| Last Updated: "+ i.getUpdatedAt() + "| Created:" + i.getCreatedAt());
        }
    }

    public void markProgress(int Id){
        loadFromFile();
        boolean found = false;

        for(Task i : tasks){
            if(i.getId() == Id){
                i.setStatus("in progress");
                System.out.println("Task set to: in progress");
                i.setUpdatedAt();
                saveAll();

                found = true;
                break;
            }
        }
    if(!found){
            System.out.println("Task not found");
        }
    }

    public void markDone(int Id){
        loadFromFile();
        boolean found = false;

        for(Task i : tasks){
            if(i.getId() == Id){
                i.setStatus("done");
                System.out.println("Task set to: done");
                i.setUpdatedAt();
                saveAll();

                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Task not found");
        }
    }

    public void listByStatus(String status){
        loadFromFile();
        for(Task i : tasks){
            if(status.equals(i.getStatus())) {
                System.out.println("ID: " + i.getId() + "| Name: " + i.getDescription() +  "| Last Updated: "+ i.getUpdatedAt() + "| Created:" + i.getCreatedAt());
            }
        }
    }
}
