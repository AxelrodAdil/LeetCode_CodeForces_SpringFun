package codeForces.solved;

import java.io.*;
import java.util.StringTokenizer;

public class G_1669 {

    private static void printCharMatrix(int n, int m, char[][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    static void solve(FastReader sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] array = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = sc.nextLine().toCharArray();
            System.arraycopy(chars, 0, array[i], 0, m);
        }
        for (int i = 0; i < m; i++) {
            int last = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                char c = array[j][i];
                if (c == 'o') {
                    last = j - 1;
                }
                if (c == '*' && last > 0) {
                    array[j][i] = '.';
                    array[last][i] = '*';
                    last -= 1;
                }
            }
        }
        printCharMatrix(n, m, array);
    }

    public static void main(String[] args) {
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
