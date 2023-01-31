package codeForces.solved;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class H_1669 {

    static void solve(FastReader sc) {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] array = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        int[] bits = new int[31];
        Arrays.stream(array).forEachOrdered(value -> IntStream.range(0, bits.length)
                .filter(j -> (value & 1 << j) != 0).forEachOrdered(j -> bits[j]++));
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
        IntStream.range(0, t).mapToObj(s -> sc).forEachOrdered(H_1669::solve);
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
