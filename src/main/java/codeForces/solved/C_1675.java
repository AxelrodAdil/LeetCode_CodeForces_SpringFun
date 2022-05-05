package codeForces.solved;

import java.io.*;
import java.util.StringTokenizer;

public class C_1675 {

    static void solve(FastReader sc) {
        String str = sc.nextLine();
        int n = str.length();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int a = n - 1;
        int b = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                a = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                b = i;
                break;
            }
        }
        System.out.println(Math.abs(a - b) + 1);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
//        int t = 1;
        int t = sc.nextInt();
        for (int s = 0; s < t; s++) {
            solve(sc);
        }
    }


    // TEMPLATES
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    static int[] setArray(int n, FastReader sc) {
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

    static int[][] setMatrix(int n, int m, FastReader sc) {
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

    static class FastReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
