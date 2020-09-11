package com.solution126;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/6/7 12:02
 */
class Solution {
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
        int i = wordList.indexOf(beginWord);
        boolean[] used = new boolean[wordList.size()];
        LinkedList<String> list = new LinkedList<>();
        list.add(beginWord);
        if (i >= 0) {
            used[i] = true;
        }
        dfs(beginWord, endWord, wordList, list, used, 1);
        return res;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, LinkedList<String> list, boolean[] used, int size) {
        if (list.size() == minSize) {
            System.out.println("&&&&&");
            return;
        }
        System.out.println("*****");
        List<String> strings = record.get(beginWord);
        if (strings.contains(endWord)) {
            list.add(endWord);
            if (list.size() < minSize) {
                minSize = list.size();
                res.clear();
                res.add(new LinkedList<>(list));
            } else if (list.size() == minSize) {
                res.add(new LinkedList<>(list));
            }
            list.removeLast();
        } else {
            for (String string : strings) {
                int i = wordList.indexOf(string);
                if (!used[i]) {
                    list.add(string);
                    used[i] = true;
                    dfs(string, endWord, wordList, list, used, size + 1);
                    list.removeLast();
                }
            }
        }
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
        String[] nums = {"kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot", "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom", "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom", "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen", "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt", "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac", "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"};
        List<String> list = new ArrayList<>(Arrays.asList(nums));
        System.out.println(list.indexOf("ism"));
        List<String> wordList = new ArrayList<>(Arrays.asList(nums));
        System.out.println(new Solution().findLadders("cet", "ism", wordList));
    }
}