public class NextPermutation {
    /**
     * link: https://www.youtube.com/watch?v=LuLCLgMElus
     * 
     * 
     * 
     */

    // leetcode: 31
    public static void nextPermutation(int[] nums) {
        int idx1 = nums.length - 2, idx2 = nums.length - 1;
        while (idx1 >= 0 && nums[idx1] >= nums[idx1 + 1])
            idx1--;

        // if idx exists
        if (idx1 >= 0) {
            while (nums[idx2] <= nums[idx1])
                idx2--;
            swap(nums, idx1, idx2);
            reverse(nums, idx1 + 1, nums.length - 1);
        } else
            reverse(nums, 0, nums.length - 1);
    }

    public static void nextPermutation1(int[] nums) {
        int idx1 = -1, idx2 = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx1 = i;
                break;
            }
        }
        if (idx1 == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            for (int i = nums.length - 1; i > idx1; i--) {
                if (nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }

            swap(nums, idx1, idx2);
            reverse(nums, idx1 + 1, nums.length - 1);
        }
    }

    private static void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int nums[], int start, int end) {
        while (start < end)
            swap(nums, start++, end--);
    }

    public static void main(String[] args) {
        int ques[][] = { { 1, 2, 3 }, { 3, 2, 1 }, { 1, 1, 5 }, { 1 }, { 1, 2 }, { 2, 1 }, { 1, 2, 3 } };

        for (int[] q : ques) {
            System.out.print("Original Array: ");
            for (int i : q) {
                System.out.print(i + " ");
            }
            nextPermutation(q);
            System.out.println();
            System.out.print("After modification: ");
            for (int i = 0; i < q.length; i++) {
                System.out.print(q[i] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

}
