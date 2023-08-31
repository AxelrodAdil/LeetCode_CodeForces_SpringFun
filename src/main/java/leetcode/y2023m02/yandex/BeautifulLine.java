package leetcode.y2023m02.yandex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BeautifulLine {

    // 13.02.2023 - B

    private static int getMaxBeauty(String s, int k) {
        var map = new HashMap<Character, Integer>();
        int maxLen = 0, start = 0, maxChanges = 0;
        for (int end = 0; end < s.length(); end++) {
            var c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxChanges = Math.max(maxChanges, map.get(c));
            while (end - start + 1 - maxChanges > k) {
                var startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    private static int getMaxBeautyButTL(String s, int k) {
        // TL: 9 test
        var maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            var j = i;
            var curr = s.charAt(i);
            var currentK = k;
            while (j < s.length() && (s.charAt(j) == curr || currentK > 0)) {
                if (s.charAt(j) != curr) currentK--;
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }

    private static String getFileData(File file) {
        var input = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.lines().forEachOrdered(line -> input.append(line).append(" "));
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }
        return input.toString();
    }

    public static void main(String[] args) {
        var file = new File("input.txt");
        var input = getFileData(file).split(" ");
        System.out.println(getMaxBeauty(input[1], Integer.parseInt(input[0])));
//        System.out.println(getMaxBeauty("acacacazxvbnmasdfghjkiaaaa", 4)); // 8
//        System.out.println(getMaxBeauty("abcaz", 2)); // 4
//        System.out.println(getMaxBeauty("helto", 2)); // 3
//        System.out.println(getMaxBeauty("effdltvrpq", 7)); // 9
    }
}
