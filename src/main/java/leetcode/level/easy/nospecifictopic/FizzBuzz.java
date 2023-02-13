package leetcode.level.easy.nospecifictopic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    // https://leetcode.com/problems/fizz-buzz/

    private final String FIZZ_BUZZ = "FizzBuzz";
    private final String FIZZ = "Fizz";
    private final String BUZZ = "Buzz";

    public List<String> fizzBuzzMain(int n) {
        /*
        Runtime: 3 ms, faster than 33.80% of Java online submissions for Fizz Buzz.
        Memory Usage: 48.5 MB, less than 33.41% of Java online submissions for Fizz Buzz.
        */
        return IntStream.rangeClosed(1, n)
                .mapToObj(e -> (e % 3 == 0 && e % 5 == 0) ? FIZZ_BUZZ : e % 3 == 0 ? FIZZ : e % 5 == 0 ? BUZZ : String.valueOf(e))
                .collect(Collectors.toList());
    }

    public List<String> fizzBuzz(int n) {
        /*
        Runtime: 2 ms, faster than 75.25% of Java online submissions for Fizz Buzz.
        Memory Usage: 48.7 MB, less than 18.38% of Java online submissions for Fizz Buzz.
        */
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add(FIZZ_BUZZ);
            } else if (i % 3 == 0) {
                ans.add(FIZZ);
            } else if (i % 5 == 0) {
                ans.add(BUZZ);
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(15));
        System.out.println(fizzBuzz.fizzBuzzMain(15));
    }
}
