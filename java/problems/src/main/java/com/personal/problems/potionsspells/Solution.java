package com.personal.problems.potionsspells;

import java.util.ArrayList;
import java.util.Arrays;

// binary search , bs
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        ArrayList<Integer> successfull = new ArrayList<>();
        Arrays.sort(potions);
        for(int k = 0 ; k < spells.length ; k++){
            int i = 0 ;
            int j = potions.length-1 ;
            int minPos = potions.length;
            while(i <= j){
                int m = (i + j)/2;
                // if you have an index that has success
                // find a lower index so you can have the
                // minimum index that has succes
                // with that you can count how many have success
                if( success <= (long)potions[m]*(long)spells[k]){
                    minPos = m;
                    j = m - 1;
                }else{
                    i = m + 1;
                }
            }
            successfull.add(potions.length - minPos);
        }
        return successfull.stream().mapToInt(x -> x).toArray();
    }
}
