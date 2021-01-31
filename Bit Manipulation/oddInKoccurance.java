import java.util.*;

public class oddInKoccurance {
    /**
     * @param args int k, int arr => Given an array which contains all elements
     *             occurring k times, but one occurs only once. Find that unique
     *             element. Here the concpet is create an array of size 32 as size
     *             of int is 32 bits if we are using long there we will be using
     *             size accordingly.For int size=4bytes => 4*8=32 bits, for long
     *             8bytes = 8*8 =64 bits[0,63]
     * 
     *             Now for every element in an array we check for the set bit and do
     *             count[pos_of_set_bit]++; ex: for 5 => 101 1st and 3rd bit (lsb to
     *             msb ) are set so we do: a[j] & (1 << i)) != 0) count[i] += 1;
     *             where i goes from [0,31] (for int)
     * 
     *             at last we iterate throug count array and calculate the number :
     *             res += (count[i] % k) * (1 << i);
     */

    public static void findUnique(int[] arr, int k) {
        int netsize = 32;
        int[] count = new int[netsize];

        /**
         * int size_of_data=4;
         * 
         * int 4bytes int netsize= size_of_data*8;
         * 
         * int[] count=new int[netsize];
         */

        for (int i = 0; i < netsize; i++) {
            // 32 times => constant
            for (int j = 0; j < arr.length; j++) {
                // O(N)
                if ((arr[j] & (1 << i)) != 0) // bit is set
                    count[i]++;
            }
        }

        int res = 0;
        for (int i = 0; i < netsize; i++) {
            res += (count[i] % k) * (1 << i);
        }
        System.out.println("Unique number is " + res);

    }

    public static void main(String[] args) {
        int a[] = { 6, 2, 5, 2, 2, 6, 6 };
        int k = 3;
        // O(n) time and space
        findUnique(a, k);
    }
}
