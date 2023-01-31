package codeForces.solved;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class F_1669 {

    static FastReader sc = new FastReader();

    static void solve() {
        int n = sc.nextInt();
        long[] array = IntStream.range(0, n).mapToLong(i -> sc.nextInt()).toArray();
        long aliceSum = array[0], bobSum = array[n - 1];
        if (n == 1) {
            System.out.println(0);
        } else if (n == 2 && aliceSum == bobSum) {
            System.out.println(2);
        } else {
            int count = 2, ans = 0, j = 1, k = n - 2;
            while (j <= k) {
                if (bobSum > aliceSum) {
                    aliceSum += array[j++];
                    count++;
                } else if (aliceSum > bobSum) {
                    bobSum += array[k--];
                    count++;
                }
                if (bobSum == aliceSum) {
                    ans = count;
                    aliceSum += array[j++];
                    count++;
                }
            }
            System.out.println(ans);
        }
    }

    //Вердикт: TIME_LIMIT_EXCEEDED    Ввод 1 200000   7 49 30 48 17 4 104 3 23 6 41
    static void solveNeedTime() {
        int n = sc.nextInt();
        ArrayList<Integer> arr = IntStream.range(0, n).mapToObj(i -> sc.nextInt()).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> arrAns1 = new ArrayList<>();
        ArrayList<Integer> arrAns2 = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            temp += arr.get(i);
            arrAns1.add(temp);
        }
        temp = 0;
        for (int i = 0; i < n - 1; i++) {
            temp += arr.get(n - i - 1);
            arrAns2.add(temp);
        }
        int ans = 0;
        for (int i = 0; i < arrAns2.size(); i++) {
            for (int j = arrAns1.size() - 1 - i; j >= 0; j--) {
                if (arrAns1.get(j).equals(arrAns2.get(i))) ans = i + j + 2;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        // solveNeedTime();
        IntStream.range(0, t).forEachOrdered(s -> solve());
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
