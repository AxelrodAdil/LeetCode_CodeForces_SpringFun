package leetcode.y2023m07.tinkoff;

import java.util.*;
import java.util.stream.IntStream;

public class C_Sumeris {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] matrixString = a.split(" ");
        int[][] matrix = new int[Integer.parseInt(matrixString[0])][Integer.parseInt(matrixString[1])];
        int[][] dangerMatrix = new int[Integer.parseInt(matrixString[2])][3];
        for (int i = 0; i < Integer.parseInt(matrixString[0]); i++) {
            var b = scanner.nextLine();
            var splitValues = b.split(" ");
            for (int j = 0; j < Integer.parseInt(matrixString[1]); j++) {
                matrix[i][j] = Integer.parseInt(splitValues[j]);
            }
        }
        for (int i = 0; i < Integer.parseInt(matrixString[2]); i++) {
            var b = scanner.nextLine();
            var splitValues = b.split(" ");
            for (int j = 0; j < 3; j++) {
                dangerMatrix[i][j] = Integer.parseInt(splitValues[j]);
            }
        }
//        System.out.println(Arrays.deepToString(matrix));
        for (int i = 0; i < Integer.parseInt(matrixString[2]); i++) {
            int y = dangerMatrix[i][0] - 1, x = dangerMatrix[i][1] - 1, s = dangerMatrix[i][2],
                    count, curr = matrix[y][x];
            count = (int) IntStream.range(0, Integer.parseInt(matrixString[1]))
                    .filter(t -> Math.abs(matrix[y][t] - curr) <= s && x != t).count();
            count += IntStream.range(0, Integer.parseInt(matrixString[0]))
                    .filter(tt -> Math.abs(matrix[tt][x] - curr) <= s && y != tt).count();
            System.out.println(count);
        }
    }


//    static int[][] maze;
//    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//    public static void main(String[] args) {
//        int[][] maze = {{5, 1, 3, 3}, {7, 6, 2, 4}, {5, 9, 1, 8}};
//        int[][] queries = {{2, 2, 1}, {3, 3, 3}, {2, 4, 5}, {1, 4, 3}, {1, 1, 2}};
//        var results = solveMaze(maze, queries);
//        Arrays.stream(results).forEachOrdered(System.out::println);
//    }
//
//    public static int[] solveMaze(int[][] maze, int[][] queries) {
//        var results = new int[queries.length];
//        C_Sumeris.maze = maze;
//        IntStream.range(0, queries.length).forEachOrdered(i -> {
//            int startX = queries[i][0] - 1, startY = queries[i][1] - 1, k = queries[i][2];
//            results[i] = findFirstMoves(k, startX, startY);
//        });
//        return results;
//    }
//
//    public static int findFirstMoves(int k, int startX, int startY) {
//        int n = maze.length, m = maze[0].length;
//        boolean[][] visited = new boolean[n][m];
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{startX, startY});
//        visited[startX][startY] = true;
//        Set<int[]> firstMoves = new HashSet<>();
//        while (!queue.isEmpty()) {
//            int[] curr = queue.poll();
//            firstMoves.add(curr);
//            Arrays.stream(directions).forEachOrdered(dir -> {
//                int nx = curr[0] + dir[0], ny = curr[1] + dir[1];
//                if (isValidMove(nx, ny, k) && !visited[nx][ny]) {
//                    queue.offer(new int[]{nx, ny});
//                    visited[nx][ny] = true;
//                }
//            });
//        }
//        return firstMoves.size() - 1;
//    }
//
//    public static boolean isValidMove(int x, int y, int k) {
//        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) return false;
//        int danger = maze[x][y], startX = Math.max(x - k, 0), endX = Math.min(x + k, maze.length - 1),
//                startY = Math.max(y - k, 0), endY = Math.min(y + k, maze[0].length - 1);
//        return IntStream.rangeClosed(startX, endX)
//                .anyMatch(i -> IntStream.rangeClosed(startY, endY)
//                .anyMatch(j -> Math.abs(maze[i][j] - danger) <= k));
//    }
}
