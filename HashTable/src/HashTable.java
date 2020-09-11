import java.util.TreeMap;

/**
 * @author LiSheng
 * @date 2020/1/7 21:05
 */
public class HashTable<K, V> {

    private static final int[] PRIME_NUM = {61, 83, 113, 151, 211, 281, 379, 509, 683, 911, 1217, 1627, 2179, 2909, 3881, 6907, 9209,
            12281, 16381, 21841, 29123, 38833, 51787, 69061, 92083, 122777, 163729, 218357, 291143, 388211, 517619, 690163, 999983, 1226959, 1635947,
            2181271, 2908361, 3877817, 5170427, 6893911, 9191891, 12255871, 16341163, 21788233, 29050993, 38734667, 51646229, 68861641, 91815541,
            122420729, 163227661, 217636919, 290182597, 386910137, 515880193, 687840301, 917120411, 1222827239, 1610612741};

    private static final int UPPER_TOL = 10;
    private static final int LOWER_TOL = 2;
    private int capacityIndex = 0;
    private TreeMap<K, V>[] hashtable;
    private int M;
    private int size;

    public HashTable() {
        this.size = 0;
        this.M = PRIME_NUM[capacityIndex];
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }


    public void add(K key, V value) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if (size >= UPPER_TOL * M && capacityIndex + 1 < PRIME_NUM.length) {
                capacityIndex++;
                resize(PRIME_NUM[capacityIndex]);
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size < LOWER_TOL * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(PRIME_NUM[capacityIndex]);
            }
        }
        return ret;
    }

    public void set(K key, V newValue) {
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " does not exist!");
        }
        map.put(key, newValue);
    }

    public boolean contains(K key) {
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newM) {

        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashtable = newHashTable;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
