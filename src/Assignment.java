public class Assignment {

    private String id;
    private String title;
    private String subject;
    private String description;
    private String deadline;
    private String priority;
    private String status;

    public Assignment(
            String id,
            String title,
            String subject,
            String description,
            String deadline,
            String priority,
            String status) {

        this.id = id;
        this.title = title;
        this.subject = subject;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    // Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Convert object into file format

    public String toFileString() {

    return id + "," +
            title + "," +
            subject + "," +
            description + "," +
            deadline + "," +
            priority + "," +
            status;
}

@Override
public String toString() {

    return String.format(
            "%-8s %-25s %-20s %-15s %-10s %-10s",
            id,
            title,
            subject,
            deadline,
            priority,
            status
    );
}
}