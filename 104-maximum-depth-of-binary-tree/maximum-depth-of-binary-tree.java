/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxD = 0;
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        solve(root,1);
        return maxD;
    }
    private void solve(TreeNode curr,int count){
        if(curr == null)
            return;
        maxD = Math.max(maxD,count);
        solve(curr.left,count+1);
        solve(curr.right,count+1);
    }
}