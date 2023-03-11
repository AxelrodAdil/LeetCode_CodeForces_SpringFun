package leetcode.march2023;

public class StringCompression {

    // https://leetcode.com/problems/string-compression/

    public int compress(char[] chars) {
        /*
        Runtime 1 ms
        Beats 98.42%
        Memory 42.3 MB
        Beats 29.22%
        */
        if (chars.length == 1) return 1;
        int i = 0, j = 0;
        while (i < chars.length) {
            int count = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            chars[j++] = chars[i++];
            if (count > 1) {
                String countStr = String.valueOf(count);
                int k = 0;
                while (k < countStr.length()) {
                    chars[j++] = countStr.charAt(k);
                    k++;
                }
            }
        }
        return j;
    }
}
