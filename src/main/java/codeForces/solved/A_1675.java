package codeForces.solved;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class A_1675 {

    static void solve(FastReader sc) {
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long x = sc.nextLong();
        long y = sc.nextLong();
        byte bool = 1;
        if (a + b + c < x + y) {
            bool = 0;
        } else if (a < x) {
            long temp = c - (x - a);
            if (temp < 0 || temp + b < y) {
                bool = 0;
            }
        } else if (b < y) {
            long temp = c - (y - b);
            if (temp < 0 || temp + a < x) {
                bool = 0;
            }
        }
        System.out.println(bool == 1 ? "YES" : "NO");
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
//        int t = 1;
        int t = sc.nextInt();
        IntStream.range(0, t).mapToObj(s -> sc).forEachOrdered(A_1675::solve);
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
