package leetcode.y2023m02;

import java.util.stream.IntStream;

public class ConstructQuadTree {

    // https://leetcode.com/problems/construct-quad-tree/

    private boolean allSame(int[][] grid, int i, int j, int w) {
        return IntStream.range(i, i + w).noneMatch(x -> IntStream.range(j, j + w).anyMatch(y -> grid[x][y] != grid[i][j]));
    }

    private NodeConstructQuadTree helper(int[][] grid, int i, int j, int w) {
        if (allSame(grid, i, j, w)) return new NodeConstructQuadTree(grid[i][j] == 1, true);
        var node = new NodeConstructQuadTree(true, false);
        node.topLeft = helper(grid, i, j, w / 2);
        node.topRight = helper(grid, i, j + w / 2, w / 2);
        node.bottomLeft = helper(grid, i + w / 2, j, w / 2);
        node.bottomRight = helper(grid, i + w / 2, j + w / 2, w / 2);
        return node;
    }

    public NodeConstructQuadTree construct(int[][] grid) {
        /*
        Runtime 14 ms
        Beats 5.73%
        Memory 43.2 MB
        Beats 20.31%
        */
        return helper(grid, 0, 0, grid.length);
    }
}

class NodeConstructQuadTree {
    public boolean val;
    public boolean isLeaf;
    public NodeConstructQuadTree topLeft;
    public NodeConstructQuadTree topRight;
    public NodeConstructQuadTree bottomLeft;
    public NodeConstructQuadTree bottomRight;


    public NodeConstructQuadTree() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public NodeConstructQuadTree(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public NodeConstructQuadTree(boolean val, boolean isLeaf, NodeConstructQuadTree topLeft,
                                 NodeConstructQuadTree topRight, NodeConstructQuadTree bottomLeft,
                                 NodeConstructQuadTree bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
