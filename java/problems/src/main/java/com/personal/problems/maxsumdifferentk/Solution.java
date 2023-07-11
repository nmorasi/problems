package com.personal.problems.maxsumdifferentk;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        long ans = 0;
        long  sum = 0;
        for(int i = 0 ;i < k ;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            sum += nums[i];
        }
        if(map.size() == k) ans = Math.max(ans,sum);
        for(int i = k ; i < n ; i++){

            // actualizar la ventana
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            map.put(nums[i-k],map.getOrDefault(nums[i-k],0)-1);

            // si hay k diferentes 
            if(map.get(nums[i-k]) == 0) map.remove(nums[i-k]);
            sum += nums[i] - nums[i-k];
            if(map.size() == k) ans = Math.max(ans,sum);
        }
        return ans;
    }
}