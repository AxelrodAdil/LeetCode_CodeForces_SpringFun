package codeForces.unsolved;

import java.io.*;
import java.util.StringTokenizer;

public class H_1669 {

    static void solve(FastReader sc) {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int[] bits = new int[31];
        for (int value : array) {
            for (int j = 0; j < bits.length; j++) {
                if ((value & 1 << j) != 0) {
                    bits[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            if (n - bits[i] <= k) {
                k -= n - bits[i];
                res += 1 << i;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
//        int t = 1;
        int t = sc.nextInt();
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
