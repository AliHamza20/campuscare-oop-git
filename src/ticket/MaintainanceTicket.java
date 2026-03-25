package ticket;

public class MaintainanceTicket extends Ticket {
    private String type; // Chair, Desk, Window, Board

    public MaintainanceTicket(String ticketId, String title, String description,
                             String location, int assignedPersonId, String type) {
        super(ticketId, title, description, location, assignedPersonId);
        this.type = type;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public double priorityScore() {
        double score = 1.0;  // changed from 5.0
        if (getLocation().toLowerCase().contains("lab")) {
            score += 1.0;  // changed from 4.0
        }
        if (type.equalsIgnoreCase("Chair") || type.equalsIgnoreCase("Desk")) {
            score += 1.0;
        }
        return score;
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Maintainance (" + type + ")";
    }
}