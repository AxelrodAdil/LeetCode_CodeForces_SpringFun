package leetcode.easy.hashmap;

public class FirstUniqueCharacterInAString {

    // https://leetcode.com/problems/first-unique-character-in-a-string/

    public int firstUniqChar(String s) {
        /*
        Runtime: 10 ms, faster than 84.47% of Java online submissions for First Unique Character in a String.
        Memory Usage: 49.9 MB, less than 51.58% of Java online submissions for First Unique Character in a String.
        */
        char[] charArray = s.toCharArray();
        int[] codeArray = new int[26];
        for (char c : charArray) {
            codeArray[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (codeArray[charArray[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();
        System.out.println(firstUniqueCharacterInAString.firstUniqChar("loveleetcode"));
        System.out.println(firstUniqueCharacterInAString.firstUniqChar("aabb"));
        System.out.println(firstUniqueCharacterInAString.firstUniqChar("leetcode"));
    }
}
