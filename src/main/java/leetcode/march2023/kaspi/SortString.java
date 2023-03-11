package leetcode.march2023.kaspi;

import java.util.stream.IntStream;

public class SortString {

    //do not change code here
    public static void main(String[] args) {
        var s = "baaaaaaaabbbbbbaaabbbbbababaaaabbbbbaaabaaabaaabababaabbaaaabbbabaaaaaabbbababbabbbabbabbabaaabbaaaaeefeeffeeeffefffeeefeefeeffeefeefffffeefeffffeefeefffefffefeefffffefefefffeefeffeeeeefeefeeeefefeeffeeeeeeffefffeeffffefeefeeeeeeffffffefeeffffeeefeffefeeffeeffffefefeeeeeeefefeefeeffffeffefeffeeefeefrssssssrrsrrssrssrrsrssrrrrssssrrsrrsssrsrsrsrrsrssrrsrssrrrrrrsrrsrrrrsssssrrrsssrrrsrsrrsrrsrrsrsrwvwwwvwwvwwwvvvvwwvvvvvvwwvwwwwvvvvwwwvwwvwwwwwwwvvwvvvvwvwvvwwwvwwwvvwvwvwwvwwvvvvwvwvwwvvwvvvvwvww";
        System.out.println(sortString(s));
    }

    public static boolean sortString(String s) {
        var chars = s.toCharArray();
        var weights = IntStream.range(0, chars.length).map(i -> chars[i] - 'a' + 1).toArray();
        IntStream.range(0, chars.length).forEachOrdered(i -> weights[i] = chars[i] - 'a' + 1);
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < weights.length - 1; i++) {
                int diff = Math.abs(weights[i] - weights[i+1]);
                if (diff > 2) {
                    return false;
                }
                if (diff == 2) {
                    if (i < weights.length - 2 && weights[i] < weights[i+2]) {
                        int temp = weights[i+1];
                        weights[i+1] = weights[i+2];
                        weights[i+2] = temp;
                        sorted = false;
                    } else if (i == weights.length - 2 || weights[i] > weights[i+2]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
