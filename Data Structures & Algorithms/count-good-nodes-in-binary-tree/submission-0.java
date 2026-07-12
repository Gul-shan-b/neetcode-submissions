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
    
    public int goodNodes(TreeNode root) {

        return count(root, root.val);

      
        
    }
    public int count(TreeNode root, int val){
        if(root ==null){
            return 0;
        }

        int res = (root.val>=val)?1:0;
        val = Math.max(root.val, val);


        res += count(root.left, val);
        res += count(root.right, val);
        
        return res;
    }


}
