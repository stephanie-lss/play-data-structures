import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author LiSheng
 * @date 2020/1/8 19:57
 */
public class HashTable2<K, V> {
    private LinkedListMap<K, V>[] hashTable;
    private TreeMap<K, V>[] treeMaps;
    private int size;
    private int M;
    private static final int UPPER_TOL = 5;

    public HashTable2() {
        size = 0;
        M = 37;
        hashTable = new LinkedListMap[M];
        treeMaps = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new LinkedListMap<>();
            treeMaps[i] = new TreeMap<>();
        }
    }

    public int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(K key, V value) {
        LinkedListMap<K, V> listMap = hashTable[hash(key)];
        if (listMap.contains(key)) {
            hashTable[hash(key)].add(key, value);
            size++;
        } else {
            hashTable[hash(key)].add(key, value);
        }

        if (size / M < UPPER_TOL) {
            return;
        }
        for (int i = 0; i < hashTable.length; i++) {
            LinkedListMap<K, V> map = hashTable[i];
            Set<K> keySet = map.keySet();
            for (K k : keySet) {
                treeMaps[hash(k)].put(k, map.get(k));
            }
        }
        return;
    }

    public V remove(K key) {
        V ret = null;
        if (size / M < UPPER_TOL) {
            //哈希表基于链表实现
            LinkedListMap<K, V> map = hashTable[hash(key)];
            if (map.contains(key)) {
                ret = map.remove(key);
            }
        } else {
            //此时哈希表基于TreeMap实现
            TreeMap<K, V> map = treeMaps[hash(key)];
            if (map.containsKey(key)) {
                ret = map.remove(key);
            }
        }
        return ret;
    }

    public void set(K key, V newValue) {
        if (size / M < UPPER_TOL) {
            //哈希表基于链表实现
            LinkedListMap<K, V> map = hashTable[hash(key)];
            if (map.contains(key)) {
                map.set(key, newValue);
            }
        } else {
            //此时哈希表基于TreeMap实现
            TreeMap<K, V> map = treeMaps[hash(key)];
            if (map.containsKey(key)) {
                map.put(key, newValue);
            }
        }
    }

    public V get(K key) {
        V ret = null;
        if (size / M < UPPER_TOL) {
            //哈希表基于链表实现
            LinkedListMap<K, V> map = hashTable[hash(key)];
            if (map.contains(key)) {
                ret = map.get(key);
            }
        } else {
            //此时哈希表基于TreeMap实现
            TreeMap<K, V> map = treeMaps[hash(key)];
            if (map.containsKey(key)) {
                ret = map.get(key);
            }
        }
        return ret;
    }

    public boolean contains(K key) {
        if (size / M < UPPER_TOL) {
            //哈希表基于链表实现
            LinkedListMap<K, V> map = hashTable[hash(key)];
            return map.contains(key);
        } else {
            //此时哈希表基于TreeMap实现
            TreeMap<K, V> map = treeMaps[hash(key)];
            return map.containsKey(key);
        }
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("MADAME BOVARY");
        ReadFile readFile = new ReadFile();
        String content = readFile.readFileContent("F:\\Github\\play data-structures\\TestTools\\src\\test2.txt");
        String[] words = content.split(" ");
        // Test HashTable
        long startTime = System.nanoTime();
        HashTable2<String, Integer> hashTable = new HashTable2<>();
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
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("HashTable2：" + time + " s.");
    }
}
