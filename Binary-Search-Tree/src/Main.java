/**
 * @author LiSheng
 * @date 2020/1/2 22:12
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        /*Random random = new Random();
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
        }*/
        bst.add(41);
        bst.add(22);
        bst.add(58);
        bst.add(15);
        bst.add(33);
        bst.add(50);
        bst.add(63);
        bst.add(13);
        bst.add(37);
        bst.add(42);
        bst.add(46);
        System.out.println(bst);

        System.out.println(bst.floor(45));
        System.out.println(bst.ceil(45));
    }
}
