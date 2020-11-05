import java.io.*;

public class AllIndexOfArray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if (iarr.length == 0) {
            System.out.println();
            return;
        }

        for (int i = 0; i < iarr.length; i++) {
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        if (idx == arr.length) {
            int[] indexes = new int[fsf];
            return indexes;
        }

        if (arr[idx] == x) {
            int indexes[] = allIndices(arr, x, idx + 1, fsf + 1);
            indexes[fsf] = idx;
            // we are updating the fsf after matching(fsf updated value in next call)
            // so when returning to recursion fsf value will actually be 1 less so we don;t
            // need to
            // do indexes[fsf-1]
            return indexes;
        } else {
            int indexes[] = allIndices(arr, x, idx + 1, fsf);
            return indexes;

        }
    }
}