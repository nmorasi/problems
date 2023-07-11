package com.personal.problems.nodesdistancek;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    Map<TreeNode,Integer> dist;
    public int plusInf(int x,int y){
        if(x == Integer.MAX_VALUE || y == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else
        {
            return x + y;
        }
    }

    void distance(TreeNode node,TreeNode father, int target) {
        if (node == null) return;

        if (!dist.containsKey(node)){
            dist.put(node, Integer.MAX_VALUE);
        }

        if(dist.containsKey(father)){

            dist.put(node,Math.min(dist.get(node),plusInf(dist.get(father),1)));
        }

        if(node.val == target){
            dist.put(node,Math.min(dist.get(node),0));
        }

        distance(node.left,node,target);
        distance(node.right,node,target);


        if(dist.containsKey(node.left)){
            dist.put(node,Math.min(dist.get(node),plusInf(dist.get(node.left),1))); ;
        }
        if(dist.containsKey(node.right)){
            dist.put(node,Math.min(dist.get(node),plusInf(dist.get(node.right),1))); ;
        }


    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dist = new HashMap<TreeNode,Integer>();
        distance(root,null,target.val);
        distance(root,null,target.val);
        List<Integer> l = new LinkedList<>();
        for(Map.Entry<TreeNode,Integer> e : dist.entrySet()){
            if(e.getValue() == k){
                l.add(e.getKey().val);
            }
        }
        return l;
    }

    public void prueba1(){
        TreeNode root = new TreeNode(3,new TreeNode(5,new TreeNode(6),new TreeNode(2,new TreeNode(7),new TreeNode(4))),new TreeNode(1,new TreeNode(0),new TreeNode(8)));
        Solution s = new Solution();
        s.distanceK(root,root.left,2);
    }
    public static void main(String[] args){
        new Solution().prueba1();
    }
}