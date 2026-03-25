package ticket;

public abstract class Ticket {
    private String ticketId;
    private String title;
    private String description;
    private String location;
    private String status;
    private int assignedPersonId;

    public Ticket(String ticketId, String title, String description, String location, int assignedPersonId) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.status = "New";
        this.assignedPersonId = assignedPersonId;
    }

    // Abstract method - each subclass must implement this
    public abstract double priorityScore();

    // Getters
    public String getTicketId() { return ticketId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getStatus() { return status; }
    public int getAssignedPersonId() { return assignedPersonId; }

    // Setters
    public void setStatus(String status) { this.status = status; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
                " | Title: " + title +
                " | Location: " + location +
                " | Status: " + status +
                " | Assigned To (Person ID): " + assignedPersonId +
                " | Priority Score: " + priorityScore();
    }
}