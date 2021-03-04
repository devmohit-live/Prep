public class Partition {
    // 0 to j-1 => region containing elements <= pivot
    // j to i-1 => region containing elements > pivot
    // i to end => region containing unknown elements

    private static void partition(int[] arr, int pivot) {
        int i = 0, j = 0;
        while (i < arr.length) {
            if (arr[i] > pivot)
                i++;
            else {
                swap(arr, i, j);
                i++;
                j++;
            }
        }
        System.out.println("Array after partitioning on the basis of pivot = " + pivot);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 9, 4, 8, 3, 6, 2, 1 };
        int pivot = 5;
        partition(arr, pivot);
    }
}
