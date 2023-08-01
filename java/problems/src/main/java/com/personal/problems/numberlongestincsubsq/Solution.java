package com.personal.problems.numberlongestincsubsq;


class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // in the first one is the length of the sequence
        // in the second one is the number of sequences
        int[][] dp = new int[n][2];
        int maxim = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = new int[]{1, 1};
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    // if the length of the sequence is greater
                    if (dp[i][0] < dp[j][0] + 1) {
                        // we have a new maximum
                        dp[i] = new int[]{dp[j][0] + 1, dp[j][1]};
                    } else if (dp[j][0] + 1 == dp[i][0]) {
                        // if it's equal then we just add the number of subsequences
                        dp[i][1] += dp[j][1];
                    }
                }
            }

            // update the maximum and the answer.
            if (maxim < dp[i][0]) {
                maxim = dp[i][0];
                ans = dp[i][1];
            } else if (maxim == dp[i][0]) {
                ans += dp[i][1];
            }
        }
        return ans;
    }
}
