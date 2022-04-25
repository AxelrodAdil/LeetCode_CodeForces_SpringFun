package codeForces.solved;

import java.io.*;
import java.util.*;

public class B_1669 {

    static Scanner scanner = new Scanner(System.in);

    static void solve(FastReader sc) {
        int n = scanner.nextInt();
//        System.out.println("NL" + n);
//        ArrayList<Integer> arr = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
            int temp = scanner.nextInt();
//            arr.add(temp);
            arr[i] = temp;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.get(arr[i]) == null) {
//                System.out.println("PUT " + arr[i]);
                hashMap.put(arr[i], 1);
            } else {
//                System.out.println("PUT add " + arr[i]);
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            }
        }
//        hashMap.forEach((key, value) -> System.out.println(key + " " + value));
        boolean bool = true;
        for (Map.Entry<Integer, Integer> set : hashMap.entrySet()) {
            if (set.getValue() >= 3) {
                System.out.println(set.getKey());
                bool = false;
                return;
            }
        }
        if (bool) {
            System.out.println(-1);
        }
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
