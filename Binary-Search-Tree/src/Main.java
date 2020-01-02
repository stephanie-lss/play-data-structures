/**
 * @author LiSheng
 * @date 2020/1/2 22:12
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        System.out.println("******");
        System.out.println(bst);
        System.out.println("*****");
        bst.inOrder();
        System.out.println();
        System.out.println("*****");
        bst.postOrder();
    }
}
