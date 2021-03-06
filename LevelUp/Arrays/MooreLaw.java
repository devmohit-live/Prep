/**
 * Majority element is an array: freq(i)>= N/2 N=> size of an aray ex: [1] N=1
 * 1/2=0 freq(1)>0 => 1
 * 
 * [1,1] n=2, n/2=1 freq(1)=2>1 => 1
 * 
 * [1,2] n=2, n/2=1 freq(1)=1 , freq(2)=1 so no majority element => -1
 * 
 * [1,1,2] n=3 3/2=1 frq(1)>1 => 1
 * 
 * [1,1,2,1] n=4 n/2=2 freq(1)=3 => 1
 * 
 * [5,1,4,1,1] n=5 5/2=2 freq(1)=3 => 1
 * 
 * We have to find the major element in O(N)
 */

public class MooreLaw {
    public static void main(String[] args) {
        int[][] question = { { 1 }, { 1, 1 }, { 1, 2 }, { 1, 1, 2, 1 }, { 5, 1, 4, 1, 1 }, { 5, 1, 4, 5, 5 },
                { 1, 1, 2, 3, 1 }, { 1, 1, 1, 3, 2 } };
        Solution ob = new Solution();
        for (int[] q : question) {
            int ans = ob.majorityElement(q);
            System.out.println(ans);
        }
    }
}

class Solution {
    public int majorityElement(int[] nums) {

        // O(1) space Moore Law

        int ansidx = 0;
        int count = 1; // for occurance of nums[0]

        // checking for probabable major element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[ansidx]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                ansidx = i;
                count = 1;
            }
        }
        int probans = nums[ansidx];
        // checking if it;s frequency actually>n/2
        int freq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == probans)
                freq++;
        }

        if (freq > nums.length / 2)
            return probans;
        return -1;

        // O(N) space
        /*
         * HashMap<Integer,Integer> hm=new HashMap<>(); int n=nums.length; for(int i:
         * nums){ hm.put(i,hm.getOrDefault(i,0)+1); }
         * 
         * for(int i: hm.keySet()){ if(hm.get(i) > n/2) return i; } return -1;
         */

    }
}