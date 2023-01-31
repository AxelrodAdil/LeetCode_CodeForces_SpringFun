package codeForces.solved;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class E_1669 {

    static void solve(FastReader sc) {
        long n = sc.nextLong();
        long count = 0;
        Map<String, Long> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String tempString = sc.nextLine();
            for (char j = 'a'; j <= 'k'; j++) {
                if (tempString.charAt(1) != j) {
                    count += hashMap.getOrDefault(tempString.charAt(0) + String.valueOf(j), 0L);
                }
            }
            for (char j = 'a'; j <= 'k'; j++) {
                if (tempString.charAt(0) != j) {
                    count += hashMap.getOrDefault(String.valueOf(j) + tempString.charAt(1), 0L);
                }
            }
            hashMap.put(tempString, hashMap.getOrDefault(tempString, 0L) + 1);
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
//        int t = 1;
        int t = sc.nextInt();
        IntStream.range(0, t).mapToObj(s -> sc).forEachOrdered(E_1669::solve);
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
