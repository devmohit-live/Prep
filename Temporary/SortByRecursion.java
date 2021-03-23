
import java.util.*;

public class SortByRecursion {
    // time complexity => O(n*n)
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(9, 5, 0, 1, 2, 8, 10, 6, 15, 3));
        System.out.println("Original array " + arr);
        sort(arr);
        System.out.println("After operation : " + arr.toString());
    }

    public static void sort(ArrayList<Integer> arr) {
        if (arr.size() == 1) // nothing to compare
            return;

        // making the input smaller
        int tmp = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        sort(arr);

        // performing induction step
        insert(arr, tmp);
        return;

    }

    // insert the value at it's correct position in array
    public static void insert(ArrayList<Integer> arr, int tmp) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) <= tmp) {

            // performing induction step , base
            arr.add(tmp);
            return;
        }
        // making the input smaller
        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        insert(arr, tmp);
        // performing induction step
        arr.add(val);
        return;
    }
}
