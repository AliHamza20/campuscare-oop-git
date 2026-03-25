package person;

public class Student extends Person {
    private String program;
    private int semester;

    public Student(int id, String name, String email, String program, int semester) {
        super(id, name, email);
        this.program = program;
        this.semester = semester;
    }

    public String getProgram() { return program; }
    public int getSemester() { return semester; }

    public void setProgram(String program) { this.program = program; }
    public void setSemester(int semester) { this.semester = semester; }

    @Override
    public String toString() {
        return super.toString() + " | Program: " + program + " | Semester: " + semester;
    }
}