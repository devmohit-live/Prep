import java.util.*;

public class PairArray {

    public static boolean solution(int[] arr) {
        Integer[] ar = new Integer[arr.length];
        HashMap<Integer, Integer> hm = new HashMap<>();

        if (arr.length == 0)
            return true;
        if (arr.length % 2 == 1)
            return false;
        for (int i = 0; i < arr.length; i++) {
            ar[i] = arr[i];
            hm.put(ar[i], hm.getOrDefault(ar[i], 0) + 1);
        }
        // System.out.println("HashMap is " + hm);

        Arrays.sort(ar, (a, b) -> {
            return Math.abs(a) - Math.abs(b);
        });

        /*
         * for element=0 => 2*0=0 hence even 0 would'nt cause any problem in even cases,
         * in the case of odd zeros the freq of 0 will become -1 and the the 2*el for
         * further elements(next to 0 in sorted array) will be calculated 1 index prior
         * to the actual element in array causing last elemet to be left alone ex:
         * [0,1,2,4,8,16] => false; 0 0 1 2 4 8 16 32 => true
         */
        for (int el : ar) {
            if (hm.get(el) == 0)
                continue;

            if (hm.getOrDefault(2 * el, 0) == 0)
                return false;

            hm.put(el, hm.get(el) - 1);
            hm.put(2 * el, hm.get(2 * el) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
