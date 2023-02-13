package leetcode.december2022.yandex;

import java.util.HashMap;
import java.util.Scanner;

public class A_39665 {

    static Scanner sc = new Scanner(System.in);

    static void solve() {
//        int n = Integer.parseInt(sc.next());
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0) + 1);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                System.out.print('P');
            } else if (map.get(str2.charAt(i)) != null && map.get(str2.charAt(i)) > 0) {
                map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
                System.out.print('S');
            } else {
                System.out.print('I');
            }
        }
    }

    public static void main(String[] args) {
        int t = 1;
//        int t = Integer.parseInt(sc.next());
        for (int s = 0; s < t; s++) {
            solve();
        }
    }
}
