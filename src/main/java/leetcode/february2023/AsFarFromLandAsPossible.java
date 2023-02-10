package leetcode.february2023;

import java.util.Arrays;

public class AsFarFromLandAsPossible {

    // https://leetcode.com/problems/as-far-from-land-as-possible/

    public int maxDistance(int[][] grid) {
        /*
        Runtime 8 ms
        Beats 92.69%
        Memory 43.1 MB
        Beats 90.72%
        */
        var rows = grid.length;
        var cols = grid[0].length;
        final int MAX_DISTANCE = rows + cols + 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = MAX_DISTANCE;
                    grid[i][j] = Math.min(grid[i][j], Math.min(i > 0 ? grid[i - 1][j] + 1 : MAX_DISTANCE,
                            j > 0 ? grid[i][j - 1] + 1 : MAX_DISTANCE));
                }
            }
        }
        var ans = Integer.MIN_VALUE;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                grid[i][j] = Math.min(grid[i][j], Math.min(i < rows - 1 ? grid[i + 1][j] + 1 : MAX_DISTANCE,
                        j < cols - 1 ? grid[i][j + 1] + 1 : MAX_DISTANCE));
                ans = Math.max(ans, grid[i][j]);
            }
        }
        return ans == 0 || ans == MAX_DISTANCE ? -1 : ans;
    }

    public int maxDistanceWithNewArray(int[][] grid) {
        var rows = grid.length;
        var cols = grid[0].length;
        final int MAX_DISTANCE = rows + cols + 1;
        var dist = new int[rows][cols];
        Arrays.stream(dist).forEachOrdered(arr -> Arrays.fill(arr, MAX_DISTANCE));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Math.min(dist[i][j], Math.min(i > 0 ? dist[i - 1][j] + 1 : MAX_DISTANCE,
                            j > 0 ? dist[i][j - 1] + 1 : MAX_DISTANCE));
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                dist[i][j] = Math.min(dist[i][j], Math.min(i < rows - 1 ? dist[i + 1][j] + 1 : MAX_DISTANCE,
                        j < cols - 1 ? dist[i][j + 1] + 1 : MAX_DISTANCE));
                ans = Math.max(ans, dist[i][j]);
            }
        }
        return ans == 0 || ans == MAX_DISTANCE ? -1 : ans;
    }
}
