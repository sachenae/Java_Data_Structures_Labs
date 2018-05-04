
import java.io.Serializable;

public class Student implements Serializable, Comparable<Student>{
    
    private String fName;
    private String lName;
    private int age;
    private float grade;
    
    public Student(){
        
    }

    public Student(String fName, String lName, int age, float grade) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.grade = grade;
    }


    @Override
    public int compareTo(Student o) {
        if(!fName.equals(o.getfName()) || !lName.equals(o.getlName())){
            if (age >= o.getAge()){
                return 1;
            }
            else{
                return -1;
            }
        }
        else{
            return 0;
        }
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    
    public String toString(){
        return this.fName +" "+ this.lName +" "+ this.age +" "+ this.grade;
    }
    
}