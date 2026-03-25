package ticket;

public class CleaningTicket extends Ticket {
    private String type; // Trash, Dirty Area

    public CleaningTicket(String ticketId, String title, String description,
                          String location, int assignedPersonId, String type) {
        super(ticketId, title, description, location, assignedPersonId);
        this.type = type;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public double priorityScore() {
        // Higher priority if description contains 'trash pile'
        double score = 4.0;
        if (getDescription().toLowerCase().contains("trash pile")) {
            score += 5.0;
        }
        if (type.equalsIgnoreCase("Trash")) {
            score += 1.0;
        }
        return score;
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Cleaning (" + type + ")";
    }
}
