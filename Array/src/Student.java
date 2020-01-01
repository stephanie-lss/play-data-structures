/**
 * @author LiSheng
 * @date 2019/12/29 22:20
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("xiaohong",100));
        arr.addLast(new Student("xiaobai",90));
        arr.addLast(new Student("xiaohei",80));
        System.out.println(arr);
    }
}
