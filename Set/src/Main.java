import java.io.IOException;

/**
 * @author LiSheng
 * @date 2020/1/4 15:13
 */
public class Main {
    private static double testSet(Set<String> set) throws IOException {
        long startTime = System.nanoTime();
        ReadFile readFile = new ReadFile();
        String content = readFile.readFileContent("F:\\Github\\play data-structures\\TestTools\\src\\test.txt");
        String[] words = content.split(" ");
        for (String word : words) {
            set.add(word);
        }
        System.out.println("Total different word：" + set.getSize());
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) throws IOException {
        BSTSet<String> bstSet = new BSTSet<>();

        System.out.println("BST Set time: " + testSet(bstSet) + " s.");
        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        System.out.println("Linked List time: " + testSet(linkedListSet) + " s.");
        System.out.println();

        AVLSet<String> avlSet = new AVLSet<>();
        System.out.println("AVL Set time: " + testSet(avlSet) + " s.");
        System.out.println();
    }
}
