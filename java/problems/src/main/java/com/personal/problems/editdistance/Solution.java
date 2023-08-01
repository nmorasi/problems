package com.personal.problems.editdistance;
class Solution {
    // min edit distance
    public int minDistance(String word1, String word2) {
        // be sure none of them are empty

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // Convert from empty to w1(0,i)
        for(int i = 0 ; i <= m ;i++){
            dp[i][0] = i;
        }

        for(int j = 0 ; j <= n ;j++){
            dp[0][j] = j;
        }

        for(int i = 1 ;i <= m ;i ++){
            for(int j = 1; j <= n; j++ ){
                dp[i][j] = Integer.MAX_VALUE;
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    // we have 3 cases, replace, delete or insert
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
                }else{
                    // if the characters are equal there is no need to
                    // do an operation
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
    // This is an example w1 = a , w2 = ab. We are adding a column and a row
    // The matrix would be something like this
    //   0 1 2
    // 0   a b
    // 1 a
}