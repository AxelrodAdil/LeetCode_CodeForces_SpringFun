package leetcode.february2023.yandex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BeautifulLine {

    // 13.02.2023 - B

    private static int getMaxBeauty(String s, int k) {
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
