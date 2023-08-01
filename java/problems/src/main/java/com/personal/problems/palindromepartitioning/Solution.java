package com.personal.problems.palindromepartitioning;

import java.util.LinkedList;
import java.util.List;

class Solution {
    boolean palindrome(String s){
        int i =0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    List<List<String>> partitionRec(String s){
        if(s.isEmpty()){
            // return this list: {{}}
            List<List<String>> l = new LinkedList<>();
            l.add(new LinkedList<String>());
            return l;
        }

        // acadaabbba
        // Recursion will be something like this
        // partition(acad): aabbba

        List<List<String>> ans = new LinkedList<>();
        for(int i = s.length()-1; i >= 0 ;i--){
            if(palindrome(s.substring(i))){
                List<List<String>> ps = partitionRec(s.substring(0,i));
                for(List<String> p : ps){
                    p.add(s.substring(i));
                    ans.add(p);
                }
            }
        }
        return ans;
    }
    public List<List<String>> partition(String s) {
        return partitionRec(s);
    }
}
