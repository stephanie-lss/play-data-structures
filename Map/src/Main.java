import java.io.IOException;

/**
 * @author LiSheng
 * @date 2020/1/7 8:38
 */
public class Main {
    public static void main(String[] args) throws IOException {
        AVLMap<String, Integer> avlMap = new AVLMap<>();
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        BSTMap<String, Integer> bstMap = new BSTMap<>();
        TrieMap trieMap = new TrieMap();
        System.out.println("AVL Map："+testMap(avlMap)+" s.");
        System.out.println("Linked List Map："+testMap(linkedListMap)+" s.");
        System.out.println("BST Map："+testMap(bstMap)+" s.");
        System.out.println("Trie Map："+testMap(trieMap)+" s.");
    }

    private static double testMap(Map<String, Integer> map) throws IOException {
        long startTime = System.nanoTime();
        ReadFile readFile = new ReadFile();
        String content = readFile.readFileContent("F:\\Github\\play data-structures\\TestTools\\src\\test.txt");
        String[] words = content.split(" ");
        for (String word : words) {
            if (map.contains(word)) {
                map.add(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println("Total different word：" + map.getSize());
        System.out.println("Frequency of sun：" + map.get("sun"));
        System.out.println("Frequency of he：" + map.get("he"));
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
