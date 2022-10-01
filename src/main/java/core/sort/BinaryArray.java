package core.sort;

public class BinaryArray {

    static int productSum(int[] arr) {
        int countOne = 0;
        for (int j : arr) {
            if (j == 1)
                countOne++;
        }
        return countOne * (countOne - 1) / 2;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1};
        System.out.println(productSum(arr));
    }
}
