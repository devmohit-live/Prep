class Search2dMatrix_74 {
    // Search in 2d sorted matrix using Binary Search
    // Time: log m + log n => O(log(m*n))
    // space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchRow(matrix, target);
        if (row == -1)
            return false;
        System.out.println(row);
        boolean is_found = binarySearch(matrix, row, target);

        return is_found;
    }

    int binarySearchRow(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;
        int maxcol = matrix[0].length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (matrix[mid][0] <= target && matrix[mid][maxcol] >= target) {
                return mid; // found potential row
            }

            if (matrix[mid][0] > target)
                hi = mid - 1;

            else if (matrix[mid][0] < target)
                lo = mid + 1;

        }

        // no rows
        return -1;
    }

    boolean binarySearch(int[][] matrix, int row, int target) {
        int lo = 0;
        int high = matrix[row].length - 1;

        while (lo <= high) {
            int mid = (lo + high) / 2;
            if (matrix[row][mid] == target) {
                System.out.println(mid);
                return true;
            }

            else if (matrix[row][mid] > target)
                high = mid - 1;
            else if (matrix[row][mid] < target)
                lo = mid + 1;

        }
        return false;
    }

}