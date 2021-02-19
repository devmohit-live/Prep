import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Question: Given an integer array instructions you are asked to create a
 * sorted array from the elements in instructions. You start with another empty
 * array nums. For each element from left to right in instructions, insert it
 * into nums.
 * 
 * The cost of each insertion is the minimum of the following: a)The number of
 * elements currently in nums that are strictly less than instructions[i]. b)The
 * number of elements currently in nums that are strictly greater than
 * instructions[i].
 * 
 * 4.For example, if inserting element 4 into nums = [2,3,4,5], the cost of
 * insertion is min(2, 1) (elements 2 and 3 are less than 4, element 5 is
 * greater than 4) and nums will become [2,3,4,4,5]. 5.Return the total cost to
 * insert all elements from instructions into nums.
 * 
 * Sample Input 6 1 2 3 6 5 4
 * 
 * Sample Output 3
 */
public class FenwickCount {
    static int[] arr;
    static int[] fen;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inp = br.readLine().split(" ");

        // while creating fenwick array for storing count we iterate array from 0 index
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }

        fen = new int[100001]; // constraint
        long cost = 0;

        for (int i = 0; i < arr.length; i++) {
            int smaller = find(arr[i] - 1);
            int greater = i - find(arr[i]);

            cost += Math.min(smaller, greater);

            update(arr[i]);
        }

        System.out.println(cost);

    }

    private static void update(int i) {
        while (i < arr.length) {
            fen[i]++; // increasing count
            i += (i & -i);
        }
    }

    private static int find(int i) {
        int count = 0;
        while (i > 0) {
            count += fen[i];
            i -= (i & -i);
        }
        return count;
    }

}