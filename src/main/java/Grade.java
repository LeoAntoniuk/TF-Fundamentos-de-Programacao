public class Grade {
    private Student student;
    private Assessment assessment;
    private double value;

    public Grade(){}

    public Grade(Student student, Assessment assessment, double value) {
        this.student = student;
        this.assessment = assessment;
        this.value = value;
    }

    public Student getStudent() {
        return student;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public double getValue() {
        return value;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
