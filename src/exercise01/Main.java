package exercise01;

import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        studentManager manager = new studentManager();
        ArrayList<Student> students = new ArrayList<>( Arrays.asList(
                new Student( "Nguyễn Văn A", 20),
                new Student( "Trần Thị B", 22),
                new Student( "Lê Văn C", 19)
        ));

        manager.addStudent(students);

    }
}