import java.lang.reflect.Array;
import java.util.Arrays;

/*
It is very important to understand why we are sending (f-k) in case of egg didn't break and again
            using a for loop where k is initiated from 1 again.

            the reason is we are checking for a range where we are min number of possibly attempt where egg didn't break.

            Let's say in simple terms there are 10 floor.
            Egg didn't break from 7th floor. So now only 10-7 = 3 floor needs to be checked.
            But to check the next 3 floor we need to use a k loop again.
            Here k=1 will represent 8th floor.
            Here k=2  will represent 9th floor.
            Here k=3  will represent 10th floor.

            So to answer the initial question , You need to check the min number of attempts in next 3 floors and that is why you are sending (f-k) and k range is (1,f-k)
            PS. I was not able to understand for 2 days why we are looping from K=1 again. Putting this explanation out incase someone gets stuck in the same point again.

    The value of k doesn't indicate the index of the array and it just indicate the number of floors.
*/

/*

Why taking max ?

we have to find the minimum number of attempt to find the critical floor, we don't know which floor would be the most optimal floor to make the first attempt hence we are trying out all the floors through the loop, also we do not know if dropping from a certain floor will cause the egg to break or not so we are testing 



*/

public class EggDroping {
    static int[][] mem;

    public static void main(String[] args) {
        // int f = 4, e = 2; //3
        int f = 10, e = 2;
        mem = new int[e + 1][f + 1]; // 1 based indexing
        Arrays.stream(mem).forEach(arr -> Arrays.fill(arr, -1));
        System.out.println(recurive(e, f));
        System.out.println("Memo " + memo(e, f));
        // Arrays.stream(mem).forEach(arr -> System.out.println(Arrays.toString(arr)));

    }

    public static int recurive(int e, int f) {
        int ans = Integer.MAX_VALUE;
        if (e == 1)
            return f;
        if (f == 0 || f == 1)
            return f;

        for (int k = 1; k <= f; k++) {
            // if egg dropped
            int a = recurive(e - 1, k - 1); // rest k-1 lower floor with e-1 left eggs
            // if egg didn;t dropped
            int b = recurive(e, f - k); // rest upper k-f floors with e eggs
            int temp = 1 + Math.max(a, b); // worst case of dropped or not
            ans = Math.min(ans, temp); // minimum attempts in worst case

            // System.out.printf("e: %d , f: %d , a= %d, b= %d , temp= %d, ans= %d \n", e,
            // f, a, b, temp, ans);
        }
        return ans;
    }

    public static int memo(int e, int f) {
        if (mem[e][f] != -1)
            return mem[e][f];

        int ans = Integer.MAX_VALUE;
        if (e == 1)
            return f;
        if (f == 0 || f == 1)
            return f;

        for (int k = 1; k <= f; k++) {
            // saving temp cache(a,b) into mem, causes wrong solution as it isn;t optimzed
            // -> loop causes differnt values
            int a = memo(e - 1, k - 1);
            int b = memo(e, f - k);

            int temp = 1 + Math.max(a, b); // worst case of dropped or not
            ans = Math.min(ans, temp); // minimum attempts in worst case
            mem[e][f] = ans;
        }
        return mem[e][f];
    }

}
