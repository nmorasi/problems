package com.personal.problems.partitiondisjoinleftright;

// https://leetcode.com/problems/partition-array-into-disjoint-intervals/description/
// suffix sum , partition 
class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] mins = new int[n];
        mins[n-1] = nums[n-1];
        for(int i = n - 2; i >= 0; i--){
            mins[i] = Math.min(nums[i],mins[i+1]);
        }
        int max = nums[0];
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n - 1; i ++){
            if(max <= mins[i+1]){
                ans = Math.min(ans,i+1);
            }
            max = Math.max(max,nums[i]);
        }
        return ans;
    }
}