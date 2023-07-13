package com.personal.problems.courseschedule;


import java.util.*;

class Solution {

    boolean cycle = false;

    // Tenemos dos marcas para los nodos una global y una local
    // la local es para saber quien está en la pila
    // la global para saber quien ya fue revisado.
    // dfs, topological sort, graph, grafica 
    void dfs(Map<Integer, List<Integer>> graph,
             Set<Integer> globalMark,
             Set<Integer> localMark,
             int v){
        if(globalMark.contains(v)){
            return;
        }
        if(localMark.contains(v)){
            cycle = true;
            return;
        }
        localMark.add(v);
        for(Integer n : graph.getOrDefault(v,new ArrayList<Integer>())){
            dfs(graph,globalMark,localMark,n);
        }
        localMark.remove(v);
        globalMark.add(v);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int[] pre : prerequisites){
            if(!graph.containsKey(pre[1])){
                graph.put(pre[1],new ArrayList<Integer>());
            }
            graph.get(pre[1]).add(pre[0]);
        }
        Set<Integer> globalMark = new HashSet<Integer>();
        Set<Integer> localMark = new HashSet<Integer>();
        for( Integer v : graph.keySet()){
            dfs(graph,globalMark,localMark,v);
        }
        return !cycle;
    }
}