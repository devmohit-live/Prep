public class QuickSelect {
    /**
     * Finding the kth samllest element in an array Time: O(n) => avergae and best,
     * Worst: O(n*n) Space: O(1)
     * 
     */

    private static int partition(int[] arr, int lo, int hi, int pivot) {
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
        // pivot index
        return j - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int quickSelect(int[] arr, int k, int lo, int hi) {

        // to select the random pivot each time to avoid worst case
        Random r = new Random();
        int randomindex = r.nextInt((hi - lo) + 1) + lo;

        // swapping randomly selected pivot with hi(to avoid code alteration)
        swap(arr, randomindex, hi);

        int pivot = arr[hi];

        int pi = partition(arr, lo, hi, pivot);
        if (k > pi) {
            return quickSelect(arr, k, pi + 1, hi);
        } else if (k < pi) {
            return quickSelect(arr, k, lo, pi - 1);
        } else {
            return pivot;
        }
    }

    public static void main(String[] args) {
        int k = 4;
        int[] arr = { 2, 8, 1, 3, 7, 6, 4, 5 };
        if (k - 1 < 0 || k - 1 >= arr.length) {
            System.out.println("Invalid Index");
            return;
        }
        System.out.println(quickSelect(arr, k - 1, 0, arr.length - 1));
    }
}
