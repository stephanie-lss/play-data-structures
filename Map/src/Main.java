/**
 * @author LiSheng
 * @date 2020/1/5 22:22
 */
public class Main {
    public static void main(String[] args) {
        TrieMap trieMap = new TrieMap();
        trieMap.add("ab", 1);
        trieMap.add("c", 2);
        trieMap.add("c", 2);
        trieMap.add("c", 2);
        trieMap.add("abc", 3);
        System.out.println(trieMap.get("ab"));
        trieMap.set("ab", 10);
        System.out.println(trieMap.get("ab"));
        System.out.println(trieMap.contains("c"));
        System.out.println(trieMap.count("c"));
        System.out.println(trieMap.contains("ab"));
        System.out.println(trieMap.remove("ab"));
        System.out.println(trieMap.contains("ab"));
    }
}
