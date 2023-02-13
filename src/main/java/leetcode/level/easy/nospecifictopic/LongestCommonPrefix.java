package leetcode.level.easy.nospecifictopic;

public class LongestCommonPrefix {

    // https://leetcode.com/problems/longest-common-prefix/

    private String smallestWord(String[] words) {
        if (words == null || words.length < 1) {
            return "";
        }
        String smallest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < smallest.length()) {
                smallest = words[i];
            }
        }
        return smallest;
    }

    private String longestCommonPrefix(String[] strs) {
        String smallestWord = smallestWord(strs);
        int length = smallestWord.length();
        for (int i = 0; i < length; i++) {
            for (String s : strs) {
                if (s.charAt(i) != smallestWord.charAt(i)) {
                    return smallestWord.substring(0, i);
                }
            }
        }
        return smallestWord;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
