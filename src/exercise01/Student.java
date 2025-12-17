package exercise01;

public class Student {
    private String name;
    private int age;
    public Student(){

    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String display() {
        return "student{" + "name=" + name + ", age=" + age + '}';
    }
}
