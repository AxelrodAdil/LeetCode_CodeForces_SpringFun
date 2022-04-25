package core;

public class Rotate {
    public static void main(String[] args) {
        permutations(5);
    }

    public static void permutations(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        permutationsUltimate(arr, 0);
    }

    public static void permutationsUltimate(int[] arr, int n) {
        if(n == arr.length-1){
            printPermutationsArray(arr);
            return;
        }
        for (int i = n; i < arr.length; i++) {
            swap(arr, i, n);
            permutationsUltimate(arr, n+1);
            swap(arr, i, n);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printPermutationsArray(int[] arr){
        for(int i:arr)
            System.out.print(i);
        System.out.println();
    }
}
