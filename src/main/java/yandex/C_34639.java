package yandex;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C_34639 {

    // WA: 2-test...

    public static final int[] PRIME_NUMBERS = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
            211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353,
            359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503,
            509, 521, 523, 541};

    public static ArrayList<Integer> primeN = new ArrayList<>();
    public static final int MAX_PRIME_NUMBER_FROM_WIKI = 1_000_000;  //https://en.wikipedia.org/wiki/List_of_prime_numbers == 7919

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private static void getPrime() {
        for (int i = 2; i <= MAX_PRIME_NUMBER_FROM_WIKI; i++) {
            if (isPrime(i)) {
                primeN.add(i);
            }
        }
    }

    private static long getGCD(long x, long y) {
        while (x != 0 && y != 0) {
            if (x > y) {
                x = x % y;
            } else {
                y = y % x;
            }
        }
        return x + y;
    }

    static long getGCDBySteinsAlgorithm(long x, long y) {
        if (x == 0) {
            return y;
        }
        if (y == 0) {
            return x;
        }
        int n;
        for (n = 0; ((x | y) & 1) == 0; n++) {
            x >>= 1;
            y >>= 1;
        }
        while ((x & 1) == 0) {
            x >>= 1;
        }
        do {
            while ((y & 1) == 0) {
                y >>= 1;
            }
            if (x > y) {
                long temp = x;
                x = y;
                y = temp;
            }
            y = (y - x);
        } while (y != 0);
        return x << n;
    }

    static void solve(FastReader sc) {
        long a = sc.nextLong();
        long b = sc.nextLong();
        long answer = 0;
        long temp = 0;
        for (int primeNumber : primeN) {
            temp = getGCDBySteinsAlgorithm(Math.abs(a * primeNumber), Math.abs(b));
            if (answer < temp) {
                answer = temp;
            }
        }
        for (int primeNumber : primeN) {
            temp = getGCDBySteinsAlgorithm(Math.abs(a), Math.abs(b * primeNumber));
            if (answer < temp) {
                answer = temp;
            }
        }
        if (a < 0 || b < 0) {
            System.out.println(answer * (-1));  // mb here?
        } else {
            System.out.println(answer);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        getPrime();
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
