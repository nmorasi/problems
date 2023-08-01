package com.personal.problems.minspeedarrive;

class Solution {
    public boolean canReach(int[] dist,double speed,double hour){
        double currHour = 0;
        for(int i : dist){
            currHour += (double)i/speed;
            if(currHour > hour){
                return false;
            }
            currHour = Math.ceil(currHour);
        }
        return true;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int i = 1;
        int j = 100000000;
        int ans = -1;
        while(i <= j){
            int m = (i+j)/2;
            if(canReach(dist,m,hour)){
                // try with less speed
                ans = m;
                j = m - 1;
            }else{
                // try with more speed
                i = m + 1;
            }
        }
        return ans;
    }
}
