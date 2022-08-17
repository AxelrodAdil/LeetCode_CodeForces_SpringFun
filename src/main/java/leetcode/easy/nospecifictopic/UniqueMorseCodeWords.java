package leetcode.easy.nospecifictopic;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UniqueMorseCodeWords {

    // https://leetcode.com/problems/unique-morse-code-words/

    public int uniqueMorseRepresentations(String[] words) {
        /*
        Runtime: 8 ms, faster than 10.06% of Java online submissions for Unique Morse Code Words.
        Memory Usage: 41.7 MB, less than 82.10% of Java online submissions for Unique Morse Code Words.
        */
        String[] morseAlphabet = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        return (int) Arrays.stream(words).map(e -> e.chars().mapToObj(
                c -> morseAlphabet[c - 'a']
        ).collect(Collectors.joining())).distinct().count();
    }

    public static void main(String[] args) {
        UniqueMorseCodeWords uniqueMorseCodeWords = new UniqueMorseCodeWords();
        System.out.println(uniqueMorseCodeWords.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
