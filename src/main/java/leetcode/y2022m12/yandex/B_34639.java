package leetcode.y2022m12.yandex;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_34639 {

    public static String reverse(String str) {
        if (str == null || str.equals("")) {
            return str;
        }
        Stack<Character> stack = new Stack<>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            stack.push(ch[i]);  // ch[i] == '\' not working for character literal!
        }
        int k = 0;
        while (!stack.isEmpty()) {
            ch[k++] = stack.pop();
        }
        return String.copyValueOf(ch);
    }

    static void solve(FastReader sc) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        String temp = "";
        for (int i = 0; i < n; i++) {
            temp = sc.nextLine();
            for (int j = 0; j < m; j++) {
                stringBuilder.append(temp.charAt(j));
            }
            hashMap.put(i, stringBuilder.reverse().toString());
            stringBuilder.setLength(0);
        }
        int tempId = 0;
        char[][] arr = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                stringBuilder.append(hashMap.get(j).charAt(i));
                if (j + 1 >= n) {
                    temp = stringBuilder.reverse().toString();
                    for (int k = 0; k < n; k++) {
                        arr[k][i] = temp.charAt(tempId++);
                    }
                }
            }
            stringBuilder.setLength(0);
            tempId = 0;
        }
        char moveChar;
        for (int i = 0; i < m; i++) {
            moveChar = arr[n - 1][m - 1];
            for (int j = n - 1; j > 0; j--) {
                if (arr[j][i] != '_' && arr[j - 1][i] != '_' && !(65 <= arr[j][i] && arr[j][i] <= 90)) {
                    arr[j][i] = arr[j - 1][i];
                }
            }
            arr[0][0] = moveChar;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
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
