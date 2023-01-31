package codeForces.solved;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B_0118 {

    static void solve(FastReader sc) {
        int n = sc.nextInt();
        IntStream.rangeClosed(-n, n).forEachOrdered(i -> {
            int top = n - Math.abs(i);
            IntStream.range(0, Math.abs(i)).mapToObj(j -> "  ").forEachOrdered(System.out::print);
            IntStream.range(0, top).mapToObj(j -> j + " ").forEachOrdered(System.out::print);
            IntStream.iterate(top, j -> j > 0, j -> j - 1).mapToObj(j -> j + " ").forEachOrdered(System.out::print);
            System.out.println(0);
        });
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = 1;
//        int t = sc.nextInt();
        IntStream.range(0, t).mapToObj(s -> sc).forEachOrdered(B_0118::solve);
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
