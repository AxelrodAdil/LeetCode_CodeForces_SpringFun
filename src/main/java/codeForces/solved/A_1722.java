package codeForces.solved;

import java.util.HashMap;
import java.util.Scanner;

public class A_1722 {

    static final Scanner sc = new Scanner(System.in);

    static boolean solve() {
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        if (n != 5) {
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char i : str.toCharArray()) {
            hashMap.put(i, hashMap.containsKey(i) ? hashMap.get(i) + 1 : 1);
        }
        for (char i : "Timur".toCharArray()) {
            if (!hashMap.containsKey(i) || hashMap.get(i) == 0) {
                return false;
            } else {
                hashMap.put(i, hashMap.get(i) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            boolean b = solve();
            System.out.println(b ? "YES" : "NO");
        }
    }

    // TEMPLATES
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
}
