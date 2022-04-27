package codeForces.solved;

import java.io.*;
import java.util.StringTokenizer;

public class C_1668 {  // A_1667

    private static boolean isIncreasing(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] >= a[i]) {
                return false;
            }
        }
        return true;
    }

    static void solve(FastReader sc) {
        int n = sc.nextInt();
        if (n == 2) {
            System.out.println(1);
            return;
        }
        if (n == 3) {
            System.out.println(2);
            return;
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (isIncreasing(a)) {
            System.out.println(a.length - 1);
            return;
        }
        long bestOption = 1 << 30;  // leftShift
        bestOption = bestOption << 30;
        for (int i = 0; i < n; i++) {
            long total = 0;
            long current = 0;
            for (int j = i + 1; j < n; j++) {
                long x = current / a[j] + 1;
                total += x;
                current = x * a[j];
            }
            current = 0;
            for (int j = i - 1; j >= 0; j--) {
                long x = current / a[j] + 1;
                total += x;
                current = x * a[j];
            }
            if (total < bestOption) {
                bestOption = total;
            }
        }
        System.out.println(bestOption);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = 1;
//        int t = sc.nextInt();
        for (int s = 0; s < t; s++) {
            solve(sc);
        }
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
