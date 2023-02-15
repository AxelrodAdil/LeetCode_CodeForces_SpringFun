package leetcode.february2023.yandex;

import java.util.Scanner;

public class SourceOrMatterOfControl {

    // 14.02.2023 - D

    private static void printResult(int k, int ansRow, int seat) {
        System.out.println(k % 2 == 0 ? ansRow + " " + seat : seat % 2 == 0 ? ansRow + " " + 1 : ansRow - 1 + " " + 2);
    }

    private static void solve(int n, int k, int row, int seat) {
        var pTicket = (row - 1) * 2 + seat;
        var ticket = k < pTicket ? (pTicket % k == 0 ? k : pTicket % k) : pTicket;
        System.out.printf("HERE-0 [%d-%d]%n", pTicket, ticket);
        int left = pTicket - k, right = pTicket + k;
        if (left <= 0 && right > n) {
            System.out.println(-1);
            return;
        }
        System.out.printf("HERE-00 [%d-%d]%n", left, right);
        var ansLeftRow = (left - seat + 2) / 2;
        ansLeftRow = ansLeftRow == 0 ? 1 : ansLeftRow;
        var ansRightRow = (int) Math.ceil(((double) right - seat + 2) / 2);
        if (ansLeftRow <= 0 || ansLeftRow == row || left == 0) {
            System.out.printf("HERE-1 [%d-%d], [%d-%d]%n", left, ansLeftRow, right, ansRightRow);
            printResult(k, ansRightRow, seat);
        } else if (ansRightRow > n || right > n) {
            System.out.printf("HERE-2 [%d-%d], [%d-%d]%n", left, ansLeftRow, right, ansRightRow);
            printResult(k, ansLeftRow, seat);
        } else {
            System.out.printf("HERE-3 [%d-%d], [%d-%d]%n", left, ansLeftRow, right, ansRightRow);
            printResult(k, row - ansLeftRow >= ansRightRow - row ? ansRightRow : ansLeftRow, seat);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int row = sc.nextInt();
        int seat = sc.nextInt();

        // WA: 8 test (Later)
        solve(n, k, row, seat);
    }

    /*

      =====

      11
      2
      5
      2
      =====

      16
      8
      4
      2

      8 2
      =====


      11
      5
      3
      2

      1 1
      =====

      33
      6
      8
      1

      11 1
      =====

      2
      2
      1
      1

      -1
      =====

      25
      2
      1
      2

      2 2
      =====

      25
      13
      7
      1

      -1
      =====

      33
      5
      8
      1

      10 2
      =====

     */
}
