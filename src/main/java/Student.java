public class Student {
    private int identification;
    private String name;
    private int age;
    private Course course;
    private int semester;

    public Student() {}

    public Student(int identification, String name, int age, Course course) {
        this.identification = identification;
        this.name = name;
        this.age = age;
        this.course = course;
        this.semester = 1;
    }

    public int getIdentification() {
        return identification;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Course getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
