package com.personal.problems.longestcommonsubs;

// longest common subsequence, dp
//  https://leetcode.com/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=amazon-spring-23-high-frequency
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int i = 0 ;i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                dp[i][j] = 0;
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = Math.max(dp[i][j],(0 <= i -1 && 0 <= j -1 ? dp[i-1][j-1] : 0 ) + 1);
                }
                dp[i][j] = Math.max(dp[i][j],0 <= i -1 ? dp[i-1][j] : 0);
                dp[i][j] = Math.max(dp[i][j],0 <= j-1 ? dp[i][j-1]: 0);
            }
        }
        return dp[n-1][m-1];
    }
}
