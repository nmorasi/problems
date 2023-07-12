package com.personal.problems.removestones;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class UnionFind{
    Map<int[],int[]> parent;
    Map<int[],Integer> size;

    public UnionFind(int[][] pairs){
        parent = new HashMap<>();
        size = new HashMap<>();

        for(int[] p : pairs){
            parent.put(p,p);
            size.put(p,1);
        }
    }

    public int[] find(int[] x){
        while(!Arrays.equals(parent.get(x),x)){
            x = parent.get(x);
        }
        return x;
    }

    public void union(int[] x, int[] y){
        int[] px = find(x);
        int[] py = find(y);
        if(Arrays.equals(px,py)) return;
        if(size.get(px) <= size.get(py)){
            parent.put(px,py);
            size.put(py,size.get(px) + size.get(py));
        }else{
            parent.put(py,px);
            size.put(px,size.get(px)+size.get(py));
        }
    }
}

// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
// union find, stones
class Solution {
    public int removeStones(int[][] stones) {
        // union find
        // all of them can be removed
        UnionFind unionFind = new UnionFind(stones);
        Map<Integer, ArrayList<int[]>> cols = new HashMap<>();
        Map<Integer,ArrayList<int[]>> rows = new HashMap<>();
        int ans = 0;
        for(int[] st : stones){
            if(!rows.containsKey(st[0])) rows.put(st[0],new ArrayList<int[]>());
            rows.get(st[0]).add(st);
            if(!cols.containsKey(st[1])) cols.put(st[1],new ArrayList<int[]>());
            cols.get(st[1]).add(st);
        }

        // une todos los que comparten filas o columnas
        for(ArrayList<int[]> c : cols.values()){
            for(int i = 0 ; i < c.size() -1 ;i++){
                unionFind.union(c.get(i),c.get(i+1));
            }
        }
        for(ArrayList<int[]> r : rows.values()){
            for(int i = 0 ; i < r.size() -1 ;i++){
                unionFind.union(r.get(i),r.get(i+1));
            }
        }

        // Sacar los grupos de la forma
        // representante -> elementos en el representante
        Map<int[],Integer> group = new HashMap<>();
        for(int[] x : unionFind.parent.keySet()){
            int[] px = unionFind.find(x);
            group.put(px,unionFind.size.get(px));
        }

        // El numero de rocas que se pueden quitar de cada
        // grupo son todas menos una.
        for(int s : group.values()){
            if(s > 1) ans += s-1;
        }

        return ans;
    }

    public static void main(String[] args){
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        Solution s = new Solution();
        s.removeStones(stones);
    }
}
