package codeForces.solved;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class B_1669 {

    static Scanner scanner = new Scanner(System.in);

    static void solve(FastReader sc) {
        int n = scanner.nextInt();
        int[] arr = new int[n];
        IntStream.range(0, n).forEachOrdered(i -> {
            int temp = scanner.nextInt();
            arr[i] = temp;
        });
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Arrays.stream(arr).forEachOrdered(j -> hashMap.put(j, hashMap.get(j) == null ? 1 : hashMap.get(j) + 1));
        for (Map.Entry<Integer, Integer> set : hashMap.entrySet()) {
            if (set.getValue() >= 3) {
                System.out.println(set.getKey());
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
//        int t = 1;
        int t = scanner.nextInt();
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
