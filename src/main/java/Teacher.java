public class Teacher {
    private int identification;
    private String name;
    private String graduation;

    public Teacher() {}

    public Teacher(int identification, String name, String graduation) {
        this.identification = identification;
        this.name = name;
        this.graduation = graduation;
    }


    public int getIdentification() {
        return identification;
    }

    public String getName() {
        return name;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }
}
