package core.sort;

class QuickSort {

    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    static void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            swapElements(arr, i, j);
        }
    }

    static int lomatoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, high);
        return (i + 1);
    }

    static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = lomatoPartition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
        return arr;
    }

    static int[] quickSortHoare(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = hoarePartition(arr, low, high);
            quickSortHoare(arr, low, partitionIndex);
            quickSortHoare(arr, partitionIndex + 1, high);
        }
        return arr;
    }

    public void run(int[] arr) {
        long timeMillis = System.currentTimeMillis();
        int[] arrQuick = quickSort(arr, 0, arr.length - 1);
//        printArray(arrQuick, arrQuick.length);
        System.out.println((double) (System.currentTimeMillis() - timeMillis));
        System.out.println("\n\n---------Hoare-Quick---------");
        long timeMillis1 = System.currentTimeMillis();
        int[] arrQuickHoare = quickSortHoare(arr, 0, arr.length - 1);
//        printArray(arrQuickHoare, arrQuickHoare.length);
        System.out.println((double) (System.currentTimeMillis() - timeMillis1));
    }
}
