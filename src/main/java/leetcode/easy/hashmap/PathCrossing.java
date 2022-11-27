package leetcode.easy.hashmap;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

    // https://leetcode.com/problems/path-crossing/description/

    public boolean isPathCrossing(String path) {
        /*
        Runtime 5 ms
        Beats 68.23%
        Memory 42.6 MB
        Beats 58.62%
         */
        Set<String> hashSet = new HashSet<>();
        int x = 0, y = 0;
        hashSet.add(x + " " + y);
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'S':
                    y--;
                    break;
                default:
                    x--;
                    break;
            }
            if (hashSet.contains(x + " " + y)) return true;
            hashSet.add(x + " " + y);
        }
        return false;
    }

    public static void main(String[] args) {
        String path = "NESWW";
        PathCrossing pathCrossing = new PathCrossing();
        System.out.println(pathCrossing.isPathCrossing(path));
    }
}
