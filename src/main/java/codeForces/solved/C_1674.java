package codeForces.solved;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class C_1674 {

    static long binPow(int x, int y) {
        if (y == 0) return 1;
        if (y == 1) return x;
        long answer = binPow(x, y / 2);
        return y % 2 == 0 ? answer * answer : answer * answer * x;
    }

    static void solve(FastReader sc) {
        String tempString = sc.nextLine();
        String secondString = sc.nextLine();
        int second = (int) IntStream.range(0, secondString.length()).filter(i -> secondString.charAt(i) == 'a').count();
        if (second == 1 && secondString.length() == 1) System.out.println(1);
        else if (second == 0) System.out.println(binPow(2, tempString.length()));
        else System.out.println(-1);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
//        int t = 1;
        int t = sc.nextInt();
        IntStream.range(0, t).mapToObj(s -> sc).forEachOrdered(C_1674::solve);
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
