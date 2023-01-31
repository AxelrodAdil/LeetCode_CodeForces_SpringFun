package codeForces.solved;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class A_1669 {

    static void solve(FastReader sc, PrintWriter out) {
        int rating = sc.nextInt();
        out.println(rating <= 1399 ? "Division 4" : rating <= 1599 ? "Division 3" : rating <= 1899 ? "Division 2" : "Division 1");
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
//        int t = 1;
        int t = sc.nextInt();
        IntStream.range(0, t).forEachOrdered(s -> solve(sc, out));
        out.close();
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
