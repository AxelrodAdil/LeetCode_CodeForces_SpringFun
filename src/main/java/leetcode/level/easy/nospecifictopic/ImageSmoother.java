package leetcode.level.easy.nospecifictopic;

public class ImageSmoother {

    // https://leetcode.com/problems/image-smoother/description/

    private int smoothPixel(int rowIndex, int columnIndex, int rows, int columns, int[][] img) {
        int sumOfPixelValues = 0;
        int numberOfNeighbors = 0;
        int modifiedRowIndex = Math.max(0, rowIndex - 1);
        while (modifiedRowIndex <= Math.min(rows - 1, rowIndex + 1)) {
            int modifiedColumnIndex = Math.max(0, columnIndex - 1);
            while (modifiedColumnIndex <= Math.min(columns - 1, columnIndex + 1)) {
                sumOfPixelValues += img[modifiedRowIndex][modifiedColumnIndex];
                numberOfNeighbors++;
                modifiedColumnIndex++;
            }
            modifiedRowIndex++;
        }
        return sumOfPixelValues / numberOfNeighbors;
    }

    public int[][] imageSmoother(int[][] img) {
        /*
        Runtime 5 ms
        Beats 96.26%
        Memory 42.8 MB
        Beats 95.24%
         */
        int rows = img.length;
        int columns = img[0].length;
        int[][] smoothedImage = new int[rows][columns];
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                smoothedImage[rowIndex][columnIndex] = smoothPixel(rowIndex, columnIndex, rows, columns, img);
            }
        }
        return smoothedImage;
    }
}
