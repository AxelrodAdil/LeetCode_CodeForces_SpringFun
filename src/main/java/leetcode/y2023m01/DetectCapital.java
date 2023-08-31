package leetcode.y2023m01;

import java.util.Objects;

public class DetectCapital {

    // https://leetcode.com/problems/detect-capital/

    public boolean detectCapitalUse(String word) {
        /*
        Runtime 2 ms
        Beats 69.88%
        Memory 40.8 MB
        Beats 77.90%
         */
        char firstCharacter = word.charAt(0);
        return Objects.equals(word, word.toLowerCase())
                || Objects.equals(word, word.toUpperCase())
                || word.equals(Character.toString(firstCharacter).concat(word.substring(1).toLowerCase()));
    }
}
