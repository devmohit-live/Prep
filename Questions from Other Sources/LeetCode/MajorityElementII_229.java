import java.util.*;

public class MajorityElementII_229 {
    // LeetCode 229
    // Moore Voting algo for 2 majority elements
    public static void main(String[] args) {
        int[][] test = { {}, { 1 }, { 1, 2 }, { 1, 1 }, { 1, 2, 2 }, { 2, 2, 2 }, { 1, 1, 2, 2 }, { 2, 2, 1, 3 },
                { 3, 2, 3 } };
        Solution ob = new Solution();
        for (int[] q : test) {
            List<Integer> ans = ob.majorityElement(q);
            System.out.println(ans);
        }
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();

        // base case

        if (nums.length == 0)
            return arr;
        else if (nums.length == 1) {
            arr.add(nums[0]);
            return arr;
        } else if (nums.length == 2) {
            arr.add(nums[0]);
            if (nums[0] != nums[1])
                arr.add(nums[1]);
            return arr;
        }

        // moores law n/r therefore max no of majority elements = r-1=>2
        int idx1 = 0;
        int idx2 = 1;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[idx1]) {
                count1++;
            } else if (nums[i] == nums[idx2]) {
                count2++;
            } else if (count1 == 0) {
                // System.out.println("Count1 becomes zero, old ans= "+nums[idx1]+" New ans
                // +"+nums[i]);
                count1 = 1;
                idx1 = i;
            } else if (count2 == 0) {
                // System.out.println("Count2 becomes zero, old ans= "+nums[idx2]+" New ans
                // +"+nums[i]);
                count2 = 1;
                idx2 = i;
            } else {
                count1--;
                count2--;
            }

        }

        int probans1 = nums[idx1];
        int probans2 = nums[idx2];
        int freq1 = 0, freq2 = 0;

        for (int i : nums) {
            if (i == probans1)
                freq1++;
            if (i == probans2)
                freq2++;
        }

        if (freq1 > nums.length / 3)
            arr.add(probans1);
        if (probans1 != probans2)
            if (freq2 > nums.length / 3)
                arr.add(probans2);

        return arr;
    }
}