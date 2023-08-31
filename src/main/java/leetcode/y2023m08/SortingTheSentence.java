package leetcode.y2023m08;

import java.util.Arrays;
import java.util.HashMap;

public class SortingTheSentence {

    public String sortSentence(String s) {
        String[] strArray = s.split(" ");
        HashMap<Integer, String> sortedHashMap = new HashMap<>();
        Arrays.stream(strArray).forEachOrdered(i -> {
            char ch = i.charAt(i.length() - 1);
            String temp = i.substring(0, i.length() - 1);
            sortedHashMap.put(ch - '0', temp.concat(" "));
        });
        return String.join("", sortedHashMap.values()).trim();
    }
}
