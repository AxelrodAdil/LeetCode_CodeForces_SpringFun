package leetcode.easy.nospecifictopic;

public class DetermineIfStringHalvesAreAlike {

    // https://leetcode.com/problems/determine-if-string-halves-are-alike/

    public boolean halvesAreAlike(String s) {
        /*
        Runtime 9 ms
        Beats 50.75%
        Memory 42 MB
        Beats 75.66%
         */
        s = s.toUpperCase();
        int alike = 0;
        int i = 0, j = s.length() / 2;
        while (j < s.length()) {
            if ("AEIOU".indexOf(s.charAt(i)) >= 0) alike++;
            if ("AEIOU".indexOf(s.charAt(j)) >= 0) alike--;
            i++;
            j++;
        }
        return alike == 0;
    }
}
