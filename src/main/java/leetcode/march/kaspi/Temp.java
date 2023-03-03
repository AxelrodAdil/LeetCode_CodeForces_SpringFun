package leetcode.march.kaspi;

import java.util.Scanner;

public class Temp {

    public static String toBinary(int num) {
        StringBuilder ans = new StringBuilder();
        if (num == 0) return "0";
        while (num > 0) {
            long remainder = num % 2;
            ans.insert(0, remainder);
            num /= 2;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String binary = toBinary(num);
        System.out.println(binary);
        scanner.close();
    }
}
