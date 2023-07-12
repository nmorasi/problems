package com.personal.problems.mergeoperationspalindrome;

class Solution {
    public int minimumOperations(int[] nums) {
        int i = 0;
        int j = nums.length -1;
        int moves = 0;
        while(i < j){
            // Indices al inicio y al final
            // The lower number will be merged with its next number.
            if(nums[i] < nums[j]){
                i++;
                nums[i] += nums[i-1];
                moves++;
            }else if(nums[j] < nums[i]){
                j--;
                nums[j] += nums[j+1];
                moves++;
            }else{
                i++;
                j--;
            }
        }
        return moves;
    }
}