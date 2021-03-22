import java.util.*;

/** 21 March am directory : Number Game */
public class NumberGame {
    public static int maxGcdAndRemove(ArrayList<Integer> arr, int n) {
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, arr.get(i));

        int count[] = new int[max + 1];

        for (int i = 0; i < n; i++)
            count[arr.get(i)]++;

        int counter = 0;
        for (int i = max; i >= 1; i--) {
            int j = i;
            while (j <= max) {
                if (count[j] > 0)
                    counter += count[j];
                j += i;

                if (counter == 2) {
                    System.out.println("Item to be remove :" + i + " and it's multiple " + (j - i));
                    Integer k = i;
                    Integer m = (j - i);
                    arr.remove(k);
                    arr.remove(m);
                    return i;
                }

            }
            counter = 0;
        }
        return 1;
    }

    public static void main(String args[]) {

        int a[] = { 8, 5, 6, 25, 6, 16 };
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i : a)
            arr.add(i);

        int n = arr.size();
        int k = n / 2;
        long sum = 0;
        while (k > 0) {
            int maxgcd = maxGcdAndRemove(arr, arr.size());
            System.out.println("maxgcd obtained is : " + maxgcd + " k is " + k + " factor : " + (k * maxgcd));
            sum = sum + (k * maxgcd);
            System.out.println("sum is : " + sum);
            --k;
        }

        System.out.println(sum);

    }

}
