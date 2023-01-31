package codeForces.solved;

import java.util.Scanner;

public class B_1722 {

    static final Scanner sc = new Scanner(System.in);

    static boolean solve() {
        int t = Integer.parseInt(sc.nextLine());
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(i) == 'R' && str1.charAt(i) != str2.charAt(i)) return false;
            if (str2.charAt(i) == 'R' && str2.charAt(i) != str1.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        int t = 1;
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            System.out.println(solve() ? "YES" : "NO");
        }
    }

    // TEMPLATES
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
}
