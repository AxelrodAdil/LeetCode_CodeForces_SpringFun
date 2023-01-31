package codeForces.solved;

import java.util.HashMap;
import java.util.Scanner;

public class C_1722 {

    static final Scanner sc = new Scanner(System.in);

    static void solve() {
        int n = Integer.parseInt(sc.next());
        String[][] arr = new String[3][n];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.next();
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }
        }
        for (int i = 0; i < 3; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (map.get(arr[i][j]) == 2) temp += 1;
                else if (map.get(arr[i][j]) == 1) temp += 3;
            }
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int t = 1;
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            solve();
        }
    }


    // TEMPLATES
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
}