package codeForces.solved;

import java.util.Scanner;
import java.util.stream.IntStream;

public class G_1722 {

    static Scanner sc = new Scanner(System.in);

    static void solve() {
        int n = Integer.parseInt(sc.next());
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp ^= i;
        }
        System.out.print((1 << 25) + temp + " " + (1 << 25) + " ");
        for (int i = 3; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int t = 1;
        int t = Integer.parseInt(sc.next());
        IntStream.range(0, t).forEach(s -> solve());
    }

    // TEMPLATES
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    static int[] setArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    static int[][] setMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    static void printMatrix(int n, int m, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static long binPow(int x, int y) {
        if (y == 0) {
            return 1;
        }
        if (y == 1) {
            return x;
        }
        long answer = binPow(x, y / 2);
        if (y % 2 == 0) {
            return answer * answer;
        }
        return answer * answer * x;
    }
}
