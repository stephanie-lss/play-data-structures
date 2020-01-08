import java.util.ArrayList;

/**
 * @author LiSheng
 * @date 2020/1/7 13:20
 */
public class Main3 {
    public static void main(String[] args) {
        int n = 20000000;

        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(i);
        }
        //Test AVL
        long startTime = System.nanoTime();
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer data : testData) {
            avl.add(data, null);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL time：" + time + " s.");

        //Test 左倾红黑树
        startTime = System.nanoTime();
        RBTree<Integer, Integer> rbTree = new RBTree<>();
        for (Integer data : testData) {
            rbTree.add(data, null);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("左倾红黑树 time：" + time + " s.");

        //Test 右倾红黑树
        startTime = System.nanoTime();
        RightRBTree<Integer, Integer> rightRBTree = new RightRBTree<>();
        for (Integer data : testData) {
            rightRBTree.add(data, null);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("右倾红黑树 time：" + time + " s.");

    }
}
