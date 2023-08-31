package leetcode.y2023m07.tinkoff;

import java.util.Scanner;
import java.util.stream.IntStream;

public class D_Sumeris {

    static Scanner sc = new Scanner(System.in);

    static int getAnswer(long digitSum) {
        while (digitSum > 9) {
            long nextDigitSum = 0;
            while (digitSum != 0) {
                nextDigitSum += digitSum % 10;
                digitSum /= 10;
            }
            digitSum = nextDigitSum;
        }
        return (int) digitSum;
    }

    static void solve() {
        int x = sc.nextInt();
        int y = sc.nextInt();
        long digitSum = 1;
        for (int i = x; i <= y; i++) {
            digitSum *= i;
            if (digitSum > 9) {
                digitSum = getAnswer(digitSum);
            }
        }
        System.out.println((int) digitSum);
    }

    public static void main(String[] args) {
        var t = sc.nextInt();
        IntStream.range(0, t).forEachOrdered(s -> solve());
    }
}
