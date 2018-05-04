

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.TreeSet;


public class  Register implements Serializable {

    private Student s;
    private TreeSet<Student> ts;

    public Register() {
        this.ts = new TreeSet<>();
    }

    public static void main(String[] args) {
        Register reg = new Register();

        boolean loop = true;
        while (loop) {
            System.out.println("What do you want to do:\n ADD/ LIST/ SAVE/ LOAD/ EXIT");
            //reg.add(s);
            Scanner reader = new Scanner(System.in);
            String[] command = reader.nextLine().split("\\s+");
            String array = command[0];

            switch (array) {
                case "ADD":
                    int age = Integer.parseInt(command[3]);
                    float grade = Float.parseFloat(command[4]);
                    Student s = new Student(command[1], command[2], age, grade);
                    reg.getTs().add(s);
                    break;
                case "LIST":
                   
                        for (Student std : reg.getTs()) {
                        System.out.println(std);
                    }
                     
                    
                    System.out.println(reg.toString());
                    break;
                case "SAVE":
                    try {
                        FileOutputStream fos = new FileOutputStream("studentList");
                        BufferedOutputStream bos = new BufferedOutputStream(fos);
                        ObjectOutputStream oos = new ObjectOutputStream(bos);
                        oos.writeObject(reg);
                        oos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "LOAD":
                    try {
                        FileInputStream fis = new FileInputStream("studentList");
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        ObjectInputStream ois = new ObjectInputStream(bis);
                       reg = (Register)ois.readObject();
                        ois.close();
                        
                        System.out.println(reg.getTs());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "EXIT":
                    loop = false;
                default:
                    break;
            }
        }
    }

    public TreeSet<Student> getTs() {
        return ts;
    }

    public void setTs(TreeSet<Student> ts) {
        this.ts = ts;
    }
    public void Check(){
        try {
                        FileInputStream fis = new FileInputStream("studentList");
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        ObjectInputStream ois = new ObjectInputStream(bis);
                        Object obj = ois.readObject();
                        ois.close();
                     
                        
                        System.out.println(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
    }
}
