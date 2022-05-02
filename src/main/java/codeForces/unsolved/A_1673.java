package codeForces.unsolved;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A_1673 {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static HashMap<Character, Integer> hashMap = new HashMap<>();

    static void solve(FastReader sc) {
        String tempString = sc.nextLine();

    }

    public static void main(String[] args) {
        for (int i = 1; i < ALPHABET.length() + 1; i++) {
            hashMap.put(ALPHABET.charAt(i - 1), i);
        }
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
