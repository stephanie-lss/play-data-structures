/**
 * @author LiSheng
 * @date 2020/1/6 9:24
 */
public class Main2 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("pig");
        trie.add("peer");
        trie.add("ok");
        trie.add("apple");
        trie.add("app");
        trie.add("hello");

        System.out.println(trie.contains("ok"));
        System.out.println(trie.remove("ok"));
        System.out.println(trie.contains("ok"));

        System.out.println(trie.contains("app"));
        System.out.println(trie.contains("apple"));
        System.out.println(trie.remove("app"));
        System.out.println(trie.contains("app"));
        System.out.println(trie.contains("apple"));

        System.out.println(trie.contains("pig"));
        System.out.println(trie.contains("peer"));
        System.out.println(trie.remove("peer"));
        System.out.println(trie.contains("pig"));
        System.out.println(trie.contains("peer"));
    }
}
