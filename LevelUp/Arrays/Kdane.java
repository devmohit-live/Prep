import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class Kdane {
    // works in all negative numbers also gives the start and end index of subaray
    public static void main(String[] args) {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        kdane(a);
        int ar[] = { -9, -9, -3, -4, -1, -2, -1 };
        kdane(ar);
        int arr[] = { 1, 2, 3, -4, 1, -2, 100 };
        kdane(arr);
    }

    private static void kdane(int[] arr) {
        int maxsofar = Integer.MIN_VALUE, currmax = arr[0];
        int start = 0, end = 0;
        int s = 0, e = 0;

        for (int i = 1; i < arr.length; i++) {
            if (currmax < 0) {
                s = i;
                currmax = arr[i];
            } else {
                currmax += arr[i];
            }
            if (maxsofar < currmax) {
                start = s;
                maxsofar = currmax;
                e = i;
                end = e;
            }
        }
        // if (maxsofar < currmax) {
        // end = arr.length - 1;
        // maxsofar = currmax;
        // }

        System.out.println("MAx sum is: " + maxsofar);
        System.out.println("Starting index: " + start);
        System.out.println("Ending index: " + end);
    }
}
