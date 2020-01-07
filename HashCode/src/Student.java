/**
 * @author LiSheng
 * @date 2020/1/7 20:36
 */
public class Student {
    int grade;
    int cls;
    String lastName;
    String firstName;

    public Student(int grade, int cls, String lastName, String firstName) {
        this.grade = grade;
        this.cls = cls;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstName.toLowerCase().hashCode();
        hash = hash * B + lastName.toLowerCase().hashCode();

//        System.out.println(hash);
//        hash = 0;
//        hash = (((((hash * B) + grade) * B + cls) * B + firstName.toLowerCase().hashCode()) * B + lastName.toLowerCase().hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Student student = (Student) obj;
        return this.grade == student.grade && this.cls == student.cls && this.lastName.toLowerCase() == student.lastName.toLowerCase() && this.firstName.toLowerCase() == student.firstName.toLowerCase();
    }
}
