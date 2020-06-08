package com.solution126;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/6/7 14:28
 */
class Solution2 {
    private List<List<String>> res;
    private int minSize = Integer.MAX_VALUE;
    private Map<String, List<String>> record;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.res = new ArrayList<>();
        if (wordList.size() == 0) {
            return res;
        }
        this.record = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < wordList.size(); j++) {
                if (i != j) {
                    if (compare(wordList.get(i), wordList.get(j))) {
                        tmp.add(wordList.get(j));
                    }
                }
            }
            record.put(wordList.get(i), tmp);
        }
        if (!record.containsKey(beginWord)) {
            List<String> tmp = new ArrayList<>();
            for (String word : wordList) {
                if (compare(word, beginWord)) {
                    tmp.add(word);
                }
            }
            record.put(beginWord, tmp);
        }
        boolean[] used = new boolean[wordList.size()];
        LinkedList<String> list = new LinkedList<>();
        list.add(beginWord);
        int c = wordList.indexOf(beginWord);
        if (c >= 0) {
            used[c] = true;
        }
        List<String> strings = record.get(beginWord);
        for (String string : strings) {
            dfs(string, endWord, wordList, list, used);
        }
        return res;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, LinkedList<String> list, boolean[] used) {
        int i = wordList.indexOf(beginWord);
        if (used[i]) {
            return;
        }
        System.out.println("*8");
        list.add(beginWord);
        used[i] = true;
        List<String> strList = record.get(beginWord);
        if (strList.contains(endWord)) {
            list.add(endWord);
            if (list.size() < minSize) {
                res.clear();
                res.add(new ArrayList<>(list));
                minSize = list.size();
            } else if (list.size() == minSize) {
                res.add(new ArrayList<>(list));
            }
            list.removeLast();
        } else {
            for (String s : strList) {
                dfs(s, endWord, wordList, list, used);
            }
        }
        used[i] = false;
        list.removeLast();
    }

    private boolean compare(String s1, String s2) {
        int size = s1.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count == size - 1;
    }

    public static void main(String[] args) {
        String[] nums = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        List<String> wordList = new ArrayList<>(Arrays.asList(nums));
        System.out.println(new Solution2().findLadders("qa", "sq", wordList));
    }
}
