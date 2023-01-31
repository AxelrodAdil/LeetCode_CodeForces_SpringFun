package codeForces.solved;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B_1668 {

    static void solve(FastReader sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        Arrays.sort(array);
        int limit = m - array[array.length - 1];
        if (limit <= 0) {
            System.out.println("NO");
            return;
        }
        int count = 0;
        byte bool = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (count >= limit) bool = 0;
            count += array[i] + 1;
        }
        System.out.println(bool == 1 ? "YES" : "NO");
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
//        int t = 1;
        int t = sc.nextInt();
        IntStream.range(0, t).mapToObj(s -> sc).forEachOrdered(B_1668::solve);
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
