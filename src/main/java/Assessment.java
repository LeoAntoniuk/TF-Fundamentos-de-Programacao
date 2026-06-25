public class Assessment {
    private String description;
    private double weight;
    private Subject subject;
    private Class[] academicClass;

    public Assessment(){}

    public Assessment(String description, double weight, Subject subject, Class[] academicClass) {
        this.description = description;
        this.weight = weight;
        this.subject = subject;
        this.academicClass = academicClass;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public Subject getSubject() {
        return subject;
    }

    public Class[] getAcademicClass() {
        return academicClass;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setAcademicClass(Class[] academicClass) {
        this.academicClass = academicClass;
    }
}
