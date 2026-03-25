package person;

public class Person {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        setEmail(email); // uses validation
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email! Must contain @. Setting to default.");
            this.email = "unknown@email.com";
        }
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Email: " + email;
    }
}