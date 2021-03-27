class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (S > sum)
            return 0;
        int s1 = (sum + S) / 2;
        int s2 = s1 - S;
        int ans = countSubsetSum(nums, s2);
        return (S + sum) % 2 == 0 ? ans : 0;

    }

    public int countSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];

                if (arr[i - 1] <= j)
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];

            }
        }

        return dp[n][sum];

    }

}

/**
 * Explanation :
 * 
 * 1. By multiplying pow(2,cnt), it will consider all the subsets of 0 which was
 * not considered earlier. 2. one more condition needs to be checked
 * i.e.if((S+sum)%2!=0) then we would never get the difference S by partitioning
 * the array into two subsets.
 */

// class Solution {
// public:
// int findTargetSumWays(vector<int>& nums, int S)
// {
// int cnt = 0,sum = 0;
// int n = nums.size();
// for(int i=0;i<nums.size();i++)
// {
// sum = sum+nums[i];
// if(nums[i]==0)
// cnt = cnt+1;
// }
// if(S > sum)
// return 0;

// if((S+sum)%2!=0)
// return 0;

// int s = (S+sum)/2;

// int dp[n+1][s+1];
// for(int i=0;i<n+1;i++)
// dp[i][0] = 1;
// for(int j=1;j<s+1;j++)
// dp[0][j] = 0;
// for(int i=1;i<n+1;i++)
// {
// for(int j=1;j<s+1;j++)
// {
// if(nums[i-1]==0)
// dp[i][j] = dp[i-1][j];
// else if(j < nums[i-1])
// dp[i][j] = dp[i-1][j];
// else
// dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
// }
// }

// return pow(2,cnt)*dp[n][s];

// }
// };
