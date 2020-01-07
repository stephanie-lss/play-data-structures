import java.io.IOException;
import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/1/6 17:04
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("MADAME BOVARY");
        ReadFile readFile = new ReadFile();
        String content = readFile.readFileContent("F:\\Github\\play data-structures\\TestTools\\src\\test.txt");
        String[] words = content.split(" ");
        Arrays.sort(words);
        // Test BST
        long startTime = System.nanoTime();
        RBTree<String, Integer> rbTree = new RBTree<>();
        for (String word : words) {
            if (rbTree.contains(word)) {
                rbTree.add(word, rbTree.get(word) + 1);
            } else {
                rbTree.add(word, 1);
            }
        }
        for (String word : words) {
            rbTree.contains(word);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST：" + time + " s.");

        // Test AVL
        startTime = System.nanoTime();
        AVLTree<String, Integer> avlTree = new AVLTree<>();
        for (String word : words) {
            if (avlTree.contains(word)) {
                avlTree.add(word, avlTree.get(word) + 1);
            } else {
                avlTree.add(word, 1);
            }
        }
        for (String word : words) {
            avlTree.contains(word);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL：" + time + " s.");
        System.out.println("*********");
        System.out.println(rbTree.getSize() + " " + avlTree.getSize());
        System.out.println(rbTree.get("he") + " " + avlTree.get("he"));
        System.out.println(rbTree.get("is") + " " + avlTree.get("is"));
    }
}
