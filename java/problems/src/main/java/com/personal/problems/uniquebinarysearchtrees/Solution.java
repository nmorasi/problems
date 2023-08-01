package com.personal.problems.uniquebinarysearchtrees;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer,Integer> dp = new HashMap<Integer,Integer>();
    public int numTrees(int n) {
        if(dp.containsKey(n)) return dp.get(n);
        if(n == 0) return 1;
        int ans = 0;
        for(int i = 0 ;i < n ;i++){
            // the number of trees with i nodes
            int l = numTrees(i);
            // the number of trees with n-1-i nodes
            int r = numTrees(n-1-i);
            ans += l*r;
        }
        dp.put(n,ans);
        return ans;
    }
}
