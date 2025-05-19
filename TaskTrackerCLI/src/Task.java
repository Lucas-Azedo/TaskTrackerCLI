import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.LocalDateTime.now;

public class Task {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    String status;
    int id;
    String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Task(int id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt =  now();
        this.updatedAt =  now();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt.format(formatter);
    }

    public String getUpdatedAt() {
        return updatedAt.format(formatter);
    }


    public void setDescription(String name) {
        this.description = name;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setUpdatedAt(){
        this.updatedAt = now();
    }
}
