public class Subject {
    private int code;
    private String name;
    private int workload;

    public Subject() {}

    public Subject(int code, String name, int workload) {
        this.code = code;
        this.name = name;
        this.workload = workload;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getWorkload() {
        return workload;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }
}
