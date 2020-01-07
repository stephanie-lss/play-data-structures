import java.util.HashMap;
import java.util.HashSet;

/**
 * @author LiSheng
 * @date 2020/1/7 20:31
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student(3, 2, "Li", "sheng");
        System.out.println(student.hashCode());
        HashSet<Student> set = new HashSet<>();
        set.add(student);
        HashMap<Student,Integer> scores = new HashMap<>();
        scores.put(student,100);
    }
}
