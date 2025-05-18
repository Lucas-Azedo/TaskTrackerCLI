import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Task {
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

    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return this.updatedAt;
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
