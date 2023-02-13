package leetcode.december2022.yandex;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A_34639 {

    // WA: 8-test...
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz ";

    private static String getCharacter(int tempSubtract) {
        int count = 0;
        do {
            count++;
            tempSubtract /= 2;
        } while (tempSubtract != 0);
        int id = count % 27;
        if (id == 0) {
            return String.valueOf(ALPHABET.charAt(ALPHABET.length() - 1));  // index
        }
        return String.valueOf(ALPHABET.charAt(id - 1));  // index
    }

    private static String getNegativeCharacter(int tempSubtract, ArrayList<Integer> arrayList) {
        int answer = 0;
        for (Integer integer : arrayList) {
            answer = tempSubtract - integer;
            if (answer < 0) {
                return getCharacter(answer * (-1) - 1);
            }
        }
        throw new RuntimeException("ERROR!");
    }

    static void solve(FastReader sc) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = sc.nextInt();
        int first = sc.nextInt();
        arrayList.add(first);
        stringBuilder.append(getCharacter(arrayList.get(0)));  // index
        int tempSubtract = 0;
        for (int i = 1; i < n; i++) {
            int temp = sc.nextInt();
            arrayList.add(temp);
            if (arrayList.get(i - 1) > arrayList.get(i)) {
                tempSubtract = arrayList.get(i) - arrayList.get(i - 1);
                stringBuilder.append(getNegativeCharacter(tempSubtract, arrayList));
            } else {
                tempSubtract = arrayList.get(i) - arrayList.get(i - 1);
                stringBuilder.append(getCharacter(tempSubtract));
            }
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = 1;
//        int t = sc.nextInt();
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
