import java.util.ArrayList;
import java.util.Random;

/**
 * @author LiSheng
 * @date 2020/1/2 22:12
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();

        //removeMin
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed.");

        //removeMax
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMax());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMax test completed.");
    }
}
