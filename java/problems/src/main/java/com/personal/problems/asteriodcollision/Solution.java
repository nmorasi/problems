package com.personal.problems.asteriodcollision;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Stream;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> ast = new Stack<Integer>();
        // this is for the asteriods going to the left such that
        // no asteroid going to right could stop.
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i : asteroids){
            if(i > 0){
                ast.push(i);
            }else{
                while(!ast.empty() && Math.abs(ast.peek()) < Math.abs(i)){
                    ast.pop();
                }
                if(ast.empty()){
                    ans.add(i);
                }else if(Math.abs(ast.peek()) == Math.abs(i)){
                    // if both have the same size 
                    ast.pop();
                }
            }
        }
        // concatenation of both streams
        return Stream.concat(ans.stream(),ast.stream()).mapToInt(x -> x).toArray();

    }
}
