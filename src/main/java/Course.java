public class Course {
    private int code;
    private String name;
    private int duration;
    private int totalSubjects;

    public Course() {}

    public Course(int code, String name, int duration, int totalSubjects) {
        this.code = code;
        this.name = name;
        this.duration = duration;
        this.totalSubjects = totalSubjects;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getTotalSubjects() {
        return totalSubjects;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTotalSubjects(int totalSubjects) {
        this.totalSubjects = totalSubjects;
    }
}
