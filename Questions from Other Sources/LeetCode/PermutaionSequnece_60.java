import java.util.ArrayList;

public class PermutaionSequnece_60 {
    // Leetcode 60
    // https://www.youtube.com/watch?v=wT7gcXLYoao
    // Time: O(n*n)
    // Space: O(N)

    public static void main(String[] args) {
        int[] ns = { 3, 4, 5, 9 };
        int[] ks = { 5, 16, 86, 10326 };
        Solution ob = new Solution();

        for (int i = 0; i < ns.length; i++) {
            System.out.println("n: " + ns[i] + " k: " + ks[i] + " Permutaion: " + ob.getPermutation(ns[i], ks[i]));
        }
    }
}

class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();

        k = k - 1; // 0 based indexing in splitted sets
        // factorial of previos number to find the splitted set size;

        int fact = 1;
        for (int i = 2; i < n; i++)
            fact *= i;

        // set to lookup
        for (int i = 1; i <= n; i++)
            arr.add(i);

        // finding the number from where to start filling the blanks(_)
        // which number from the set to be choosen to fill the blank (1 at a time => 1
        // at each iteration)
        // ex: {1,2,3,4}=> ? _ _ _ ans:=3
        // : {1,2,4}=> 3 ? _ _ ans: ?=4
        // : {1,2}=> 3 4 ? _ ans:?=1
        // {1} => 3 4 1 ? ans:1
        // {} => break

        while (true) {
            // find the index
            int lookup = k / fact;
            sb.append(arr.get(lookup));
            // remove the element that is being added
            arr.remove(lookup);

            if (arr.size() == 0)
                break;
            // update the k
            k %= fact;
            // size is reduced by 1 so fact=is divided by n(current size of set)
            fact /= arr.size();
        }

        return sb.toString();
    }
}
