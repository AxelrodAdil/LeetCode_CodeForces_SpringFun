package codeForces.solved;

import java.io.*;
import java.util.StringTokenizer;

public class B_0118 {

    static void solve(FastReader sc) {
        int n = sc.nextInt();
        for (int i = -n; i <= n; i++) {
            int top = n - Math.abs(i);
            for (int j = 0; j < Math.abs(i); j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < top; j++) {
                System.out.print(j + " ");
            }
            for (int j = top; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println(0);
        }
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
