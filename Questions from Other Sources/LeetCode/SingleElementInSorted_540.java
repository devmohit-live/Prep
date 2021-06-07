class SingleElementInSorted_540 {

    // Time: O(log n), Space : O(1)

    // cleaned code
    public int singleNonDuplicate(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;

            if (((mid & 1) == 0 && nums[mid] == nums[mid + 1]) || ((mid & 1) == 1 && nums[mid - 1] == nums[mid]))
                s = mid + 1;

            else
                e = mid;
        }

        return nums[s];
    }

    public int singleNonDuplicate_commenetd(int[] nums) {
        int s = 0, e = nums.length - 1;
        // every pair (set of two same numbers) start from even index;
        // not s<=e as some cases will fall in loop ex [1,1,2,3,3,4,4] at last state =>
        // s=2,e=2,mid=2 again e=mid=2 then cycle will continue

        while (s < e) {
            int mid = s + (e - s) / 2;

            if ((mid & 1) != 1) {
                // we are at even index so next elemnt should be same => a[mid] = a[mid+1]
                if (nums[mid] == nums[mid + 1]) {
                    // till here everything is fine goto next part
                    s = mid + 1;
                } else {
                    // something went wrong until here -> check before
                    e = mid;
                }

            } else {
                // we are at odd index so previous elemnt should be same => a[mid-1] = a[mid]
                if (nums[mid - 1] == nums[mid]) {
                    // till here everything is fine goto next part
                    s = mid + 1;
                } else {
                    // something went wrong until here -> check before
                    e = mid;
                }
            }

        }

        return nums[s];
    }
}

// Explanation:
/*
 * EXPLANATION:- Suppose array is [1, 1, 2, 2, 3, 3, 4, 5, 5] we can observe
 * that for each pair, first element takes even position and second element
 * takes odd position for example, 1 is appeared as a pair, so it takes 0 and 1
 * positions. similarly for all the pairs also.
 * 
 * this pattern will be missed when single element is appeared in the array.
 * 
 * From these points, we can implement algorithm. 1. Take left and right
 * pointers . left points to start of list. right points to end of the list. 2.
 * find mid. if mid is even, then it's duplicate should be in next index. or if
 * mid is odd, then it's duplicate should be in previous index. check these two
 * conditions, if any of the conditions is satisfied, then pattern is not
 * missed, so check in next half of the array. i.e, left = mid + 1 if condition
 * is not satisfied, then the pattern is missed. so, single number must be
 * before mid. so, update end to mid. 3. At last return the nums[left]
 * 
 * Time: - O(logN) space:- O(1)
 */
