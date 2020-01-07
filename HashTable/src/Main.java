import java.io.IOException;

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
//        Arrays.sort(words);
        // Test BST
        long startTime = System.nanoTime();
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        for (String word : words) {
            if (bstMap.contains(word)) {
                bstMap.add(word, bstMap.get(word) + 1);
            } else {
                bstMap.add(word, 1);
            }
        }
        for (String word : words) {
            bstMap.contains(word);
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

        // Test 红黑树
        startTime = System.nanoTime();
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
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("红黑树：" + time + " s.");

        // Test HashTable
        startTime = System.nanoTime();
        HashTable<String, Integer> hashTable = new HashTable<>();
        for (String word : words) {
            if (hashTable.contains(word)) {
                hashTable.add(word, hashTable.get(word) + 1);
            } else {
                hashTable.add(word, 1);
            }
        }
        for (String word : words) {
            hashTable.contains(word);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("HashTable：" + time + " s.");
    }
}
