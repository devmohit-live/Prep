public class TrapRainWater {
    // leetcode 42
    // Time ans Space: O(N) using prefixmax and suffixmax
    public static int trap1(int[] height) {
        if (height == null || height.length <= 2)
            return 0;

        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], height[i]);
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], height[i]);

        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += Math.min(left[i], right[i]) - height[i];

        return ans;
    }

    // Using 2 pointer approach Time: O(N), Space: O(1)
    public int trapBetter(int[] height) {
        if (height == null || height.length <= 2)
            return 0;

        int n = height.length;
        int l = 0, r = n - 1;
        int lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE;
        int res = 0;
        while (l <= r) {
            // left
            if (height[l] <= height[r]) {
                // lmax needed to be updated
                if (height[l] > lmax)
                    lmax = height[l];
                else {
                    res += lmax - height[l];
                }
                l++;
            } else {
                if (height[r] > rmax)
                    rmax = height[r];
                else {
                    res += rmax - height[r];
                }
                r--;
            }
        }
        return res;
    }

}
