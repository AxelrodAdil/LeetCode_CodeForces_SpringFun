package leetcode.medium.nospecifictopic;

public class RotateImage {

    // https://leetcode.com/problems/rotate-image/

    public void rotate(int[][] matrix) {
        /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
        Memory Usage: 42.6 MB, less than 65.89% of Java online submissions for Rotate Image.
         */
        int n = matrix.length;
        int t = (n / 2) - 1;
        for (int i = 0; i <= n - 1; i++) {
            for (int j = i + 1; j <= matrix[i].length - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= t; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
