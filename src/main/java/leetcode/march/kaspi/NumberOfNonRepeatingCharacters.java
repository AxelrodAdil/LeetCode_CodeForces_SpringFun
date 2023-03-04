package leetcode.march.kaspi;

import java.util.Scanner;
import java.util.stream.IntStream;

public class NumberOfNonRepeatingCharacters {

    //do not change code here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(numberOfNonRecurringCharacters("IJWKNBFESQAHMGCYPLOUVDTeilkpqwocyjmhgvbdtxusa"));
        scanner.close();
    }

    public static int numberOfNonRecurringCharacters(String s) {
        //write your implementation here
        var counts = new int[58]; // [65, 122]
        IntStream.range(0, s.length()).forEachOrdered(i -> counts[s.charAt(i) - 'A']++);
        return (int) IntStream.range(0, s.length()).filter(i -> counts[s.charAt(i) - 'A'] == 1).count();
    }
}
