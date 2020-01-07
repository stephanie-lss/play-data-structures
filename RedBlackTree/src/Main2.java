import java.util.ArrayList;
import java.util.Random;

/**
 * @author LiSheng
 * @date 2020/1/7 13:14
 */
public class Main2 {
    public static void main(String[] args) {
        int n = 20000000;

        Random random = new Random();

        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }

        //Test BST
        long startTime = System.nanoTime();
        BSTMap<Integer, Integer> bst = new BSTMap<>();
        for (Integer data : testData) {
            bst.add(data, null);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST time：" + time + " s.");

        //Test AVL
        startTime = System.nanoTime();
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer data : testData) {
            avl.add(data, null);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL time：" + time + " s.");

        //Test 红黑树
        startTime = System.nanoTime();
        RBTree<Integer, Integer> rbTree = new RBTree<>();
        for (Integer data : testData) {
            rbTree.add(data, null);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("红黑树 time：" + time + " s.");

    }

}
