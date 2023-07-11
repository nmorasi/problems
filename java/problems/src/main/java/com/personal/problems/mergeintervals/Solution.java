package com.personal.problems.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
// interval, merge, arraylist sort
class Solution {
    public int[][] merge(int[][] intervals) {
        Comparator<int[]> comp  = (int[] a ,int [] b) -> Integer.compare(a[0],b[0]);
        Arrays.sort(intervals, comp);
        int currFirst = intervals[0][0];
        int currLast = intervals[0][1];
        ArrayList<int[]> ans = new ArrayList<int[]>();
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= currLast ){
                currLast = Math.max(currLast,intervals[i][1]);
            }else{

                // anadir nuevo intervalo.
                ans.add(new int[]{currFirst,currLast});
                currFirst = intervals[i][0];
                currLast = intervals[i][1];
            }
        }
        ans.add(new int[]{currFirst,currLast});
        return ans.toArray(new int[ans.size()][2]);
    }
}