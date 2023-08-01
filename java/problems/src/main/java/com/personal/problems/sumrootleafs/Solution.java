package com.personal.problems.sumrootleafs;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
      this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
class Solution {
    int ans = 0;
    public void sumRec(TreeNode root,int currVal){
        if(root == null) return;
        // When you reach a leaf add the value to the answer 
        if(root.left == null && root.right == null){
            ans += root.val + currVal*10;
            return;
        }
        sumRec(root.left,currVal*10+root.val);
        sumRec(root.right,currVal*10+root.val);

    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sumRec(root,0);
        return ans;
    }
}