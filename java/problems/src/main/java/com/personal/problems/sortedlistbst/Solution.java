package com.personal.problems.sortedlistbst;

import java.util.ArrayList;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
class Solution {
    TreeNode createTree(ArrayList<ListNode> nodes, int i, int j){
        if(j < i) return null;
        int m = (i + j)/2;
        return new TreeNode(nodes.get(m).val, createTree(nodes,i,m-1),createTree(nodes,m+1,j ));
    }
    public TreeNode sortedListToBST(ListNode head) {
        // put them in array 
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        for(ListNode curr = head; curr != null ; curr = curr.next){
            nodes.add(curr);
        }
        return createTree(nodes,0,nodes.size()-1);

    }
}
