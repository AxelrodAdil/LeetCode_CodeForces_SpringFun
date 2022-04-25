package codeForces.solved;

import java.util.ArrayList;
import java.util.Scanner;

public class C_1669 {

    static Scanner sc = new Scanner(System.in);

    static void solve() {
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int first = arr.get(0);
        int second = arr.get(1);
        int i = 2;
        if (first % 2 == 0) {
            while (i < arr.size()) {
                if (arr.get(i) % 2 == 1) {
                    System.out.println("NO");
                    return;
                }
                i += 2;
            }
        } else {
            while (i < arr.size()) {
                if (arr.get(i) % 2 == 0) {
                    System.out.println("NO");
                    return;
                }
                i += 2;
            }
        }
        i = 3;
        if(i >= arr.size()){
            System.out.println("YES");
            return;
        }

        if (second % 2 == 0) {
            while (i < arr.size()) {
                if (arr.get(i) % 2 == 1) {
                    System.out.println("NO");
                    return;
                }
                i += 2;
            }
        } else {
            while (i < arr.size()) {
                if (arr.get(i) % 2 == 0) {
                    System.out.println("NO");
                    return;
                }
                i += 2;
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) {
//        int t = 1;
        int t = sc.nextInt();
        for (int s = 0; s < t; s++) {
            solve();
        }
    }
}
