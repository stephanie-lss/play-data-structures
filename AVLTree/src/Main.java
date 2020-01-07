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
        BST<String, Integer> bst = new BST<>();
        for (String word : words) {
            if (bst.contains(word)) {
                bst.add(word, bst.get(word) + 1);
            } else {
                bst.add(word, 1);
            }
        }
        for (String word : words) {
            bst.contains(word);
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
        System.out.println(bst.getSize()+" "+avlTree.getSize());
        System.out.println(bst.get("he")+" "+avlTree.get("he"));
        System.out.println(bst.get("is")+" "+avlTree.get("is"));
    }
}
