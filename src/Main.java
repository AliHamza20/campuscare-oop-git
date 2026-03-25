import person.Person;
import person.Student;
import person.Staff;
import ticket.Ticket;
import ticket.MaintainanceTicket;
import ticket.CleaningTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Person> persons = new ArrayList<>();
    static List<Ticket> tickets = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int ticketCounter = 1;

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 5) {
            System.out.println(" CampusCare - Campus Maintenance System ");
            System.out.println("1. Add Person (Student or Staff)");
            System.out.println("2. Create Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Update Ticket Status");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1: addPerson(); break;
                case 2: createTicket(); break;
                case 3: viewAllTickets(); break;
                case 4: updateTicketStatus(); break;
                case 5: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void addPerson() {
        System.out.println("\n-- Add Person --");
        System.out.println("1. Student");
        System.out.println("2. Staff");
        System.out.print("Choose type: ");
        String typeChoice = scanner.nextLine().trim();

        System.out.print("Enter ID: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        if (typeChoice.equals("1")) {
            System.out.print("Enter Program: ");
            String program = scanner.nextLine().trim();
            System.out.print("Enter Semester: ");
            int semester;
            try {
                semester = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid semester.");
                return;
            }
            persons.add(new Student(id, name, email, program, semester));
            System.out.println("Student added successfully!");

        } else if (typeChoice.equals("2")) {
            System.out.print("Enter Department: ");
            String department = scanner.nextLine().trim();
            persons.add(new Staff(id, name, email, department));
            System.out.println("Staff added successfully!");

        } else {
            System.out.println("Invalid type.");
        }
    }

    static void createTicket() {
        if (persons.isEmpty()) {
            System.out.println("No persons found. Please add a person first.");
            return;
        }

        System.out.println("\n-- Create Ticket --");
        System.out.println("1. Maintenance Ticket");
        System.out.println("2. Cleaning Ticket");
        System.out.print("Choose ticket type: ");
        String typeChoice = scanner.nextLine().trim();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter Description: ");
        String description = scanner.nextLine().trim();

        System.out.print("Enter Location: ");
        String location = scanner.nextLine().trim();

        System.out.print("Enter Person ID to assign: ");
        int personId;
        try {
            personId = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid person ID.");
            return;
        }

        // Check person exists
        boolean found = false;
        for (Person p : persons) {
            if (p.getId() == personId) { found = true; break; }
        }
        if (!found) {
            System.out.println("Person with ID " + personId + " not found.");
            return;
        }

        String ticketId = "T" + ticketCounter++;

        if (typeChoice.equals("1")) {
            System.out.println("Maintenance type: Chair / Desk / Window / Board");
            System.out.print("Enter type: ");
            String mType = scanner.nextLine().trim();
            tickets.add(new MaintainanceTicket(ticketId, title, description, location, personId, mType));
            System.out.println("Maintenance ticket created! ID: " + ticketId);

        } else if (typeChoice.equals("2")) {
            System.out.println("Cleaning type: Trash / Dirty Area");
            System.out.print("Enter type: ");
            String cType = scanner.nextLine().trim();
            tickets.add(new CleaningTicket(ticketId, title, description, location, personId, cType));
            System.out.println("Cleaning ticket created! ID: " + ticketId);

        } else {
            System.out.println("Invalid ticket type.");
        }
    }

    static void viewAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets found.");
            return;
        }
        System.out.println("\n-- All Tickets --");
        for (Ticket t : tickets) {
            System.out.println(t); // uses polymorphism
        }
    }

    static void updateTicketStatus() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets found.");
            return;
        }

        System.out.print("Enter Ticket ID to update: ");
        String ticketId = scanner.nextLine().trim();

        for (Ticket t : tickets) {
            if (t.getTicketId().equalsIgnoreCase(ticketId)) {
                System.out.println("Current status: " + t.getStatus());
                System.out.println("1. New");
                System.out.println("2. Assigned");
                System.out.println("3. Resolved");
                System.out.print("Choose new status: ");
                String statusChoice = scanner.nextLine().trim();

                switch (statusChoice) {
                    case "1": t.setStatus("New"); break;
                    case "2": t.setStatus("Assigned"); break;
                    case "3": t.setStatus("Resolved"); break;
                    default: System.out.println("Invalid status choice."); return;
                }
                System.out.println("Status updated to: " + t.getStatus());
                return;
            }
        }
        System.out.println("Ticket ID not found.");
    }
}
