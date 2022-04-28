package codeForces.solved;

import java.io.*;
import java.util.StringTokenizer;

public class D_1669 {

    static void solve(FastReader sc) {
        int n = sc.nextInt();
        char[] charArray = sc.next().toCharArray();
        byte bool = 1;
        for (int i = 0; i < n; i++) {
            if (charArray[i] != 'W') {
                int j = i;
                int rCount = 0, bCount = 0;
                while (j < n && charArray[j] != 'W') {
                    if (charArray[j] == 'R') {
                        rCount++;
                    } else {
                        bCount++;
                    }
                    j++;
                }
                if (j - i == 1) {
                    bool = 0;
                    break;
                }
                if (rCount == 0 || bCount == 0) {
                    bool = 0;
                    break;
                }
                i = j;
            }
        }
        System.out.println(bool == 1 ? "YES" : "NO");
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
