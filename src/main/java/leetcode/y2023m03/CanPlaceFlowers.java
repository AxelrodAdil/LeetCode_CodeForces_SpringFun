package leetcode.y2023m03;

public class CanPlaceFlowers {

    // https://leetcode.com/problems/can-place-flowers/

    //brute
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /*
        Runtime 1 ms
        Beats 100%
        Memory 44.4 MB
        Beats 16.79%
        */
        int ans = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean boolLeft = i == 0 || flowerbed[i - 1] == 0;
                boolean boolRight = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
                if (boolLeft && boolRight) {
                    flowerbed[i] = 1;
                    ans++;
                    if (ans >= n) {
                        return true;
                    }
                }
            }
        }
        return ans >= n;
    }
}
