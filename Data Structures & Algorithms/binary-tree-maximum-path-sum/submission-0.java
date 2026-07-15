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
    int max_sum;
    public int solve(TreeNode root){
        if(root== null){
            return 0;

        }
        int l = solve(root.left);
        int r = solve(root.right);
        int down = l+r+root.val;

        int any_from_two = Math.max(l,r)+root.val;
        int root_only = root.val;

        max_sum = Math.max(max_sum,
          Math.max(down,
          Math.max(any_from_two, root_only)));
        return Math.max(any_from_two,root_only);

    }
    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        solve(root);
        return max_sum;
        
    }
}
