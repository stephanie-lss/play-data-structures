import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Solution {
    private class Freq implements Comparable<Freq> {
        int e, freq;


        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(k) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.dequeue().e);
        }
        return res;
    }
}  