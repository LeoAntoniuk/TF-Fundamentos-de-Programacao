public class Class {
    private int number;
    private String name;
    private Teacher teacher;
    private Student[] students;
    private Subject subject;
    private int studentsNum;

    public Class(){}

    public Class(int number, String name, Teacher teacher, Subject subject) {
        this.number = number;
        this.name = name;
        this.teacher = teacher;
        this.subject = subject;
        students = new Student[30];
        this.studentsNum = 0;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student[] getStudents() {
        return students;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getStudentsNum() {
        return studentsNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setStudentsNum(int studentsNum) {
        this.studentsNum = studentsNum;
    }
}
