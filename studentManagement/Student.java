package studentManagement;

public class Student {
    private int sId;
    private String sName;
    private int age;

    public Student(){
        super();
    }
    public Student(int sId, String sName, int age) {
        this.sId = sId;
        this.sName = sName;
        this.age = age;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                '}';
    }
}
