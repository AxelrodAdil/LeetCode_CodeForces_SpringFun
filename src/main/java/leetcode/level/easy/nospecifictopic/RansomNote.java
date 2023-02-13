package leetcode.level.easy.nospecifictopic;

import java.util.HashMap;

public class RansomNote {

    // https://leetcode.com/problems/ransom-note/

    public boolean canConstruct(String ransomNote, String magazine) {
        /*
        Runtime: 27 ms, faster than 35.02% of Java online submissions for Ransom Note.
        Memory Usage: 52.6 MB, less than 22.33% of Java online submissions for Ransom Note.
        */
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char i : magazine.toCharArray()) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        for (char i : ransomNote.toCharArray()) {
            if (!hashMap.containsKey(i) || hashMap.get(i) == 0) {
                return false;
            } else {
                hashMap.put(i, hashMap.get(i) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("aa", "ab"));
        System.out.println(ransomNote.canConstruct("aa", "aab"));
    }
}
