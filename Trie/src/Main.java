import java.io.IOException;

/**
 * @author LiSheng
 * @date 2020/1/5 18:33
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile();
        String content = readFile.readFileContent("F:\\Github\\play data-structures\\Trie\\src\\POP.txt");
        String[] words = content.split(" ");
        long startTime = System.nanoTime();
        Trie trie = new Trie();
        if (words.length != 0) {
            for (String word : words) {
                trie.addNR(word);
            }
            for (String word : words) {
                trie.containsNR(word);
            }
        }

        long endTime = System.nanoTime();
        double time1 = (endTime - startTime) / 1000000000.0;
        System.out.println("POP.txt have different words :" + trie.getSize());
        System.out.println("Trie Time: " + time1);

        startTime = System.nanoTime();
        BSTSet<String> bstSet = new BSTSet<>();
        if (words.length != 0) {
            for (String word : words) {
                bstSet.add(word);
            }
            for (String word : words) {
                bstSet.contains(word);
            }
        }

        endTime = System.nanoTime();
        double time2 = (endTime - startTime) / 1000000000.0;
        System.out.println("POP.txt have different words :" + bstSet.getSize());
        System.out.println("BSTSet Time: " + time2);
    }
}
