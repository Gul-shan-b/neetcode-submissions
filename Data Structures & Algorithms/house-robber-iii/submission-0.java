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

    public int rob(TreeNode root) {
        int[] options = travel(root);
        return Math.max(options[0], options[1]);
        
    }
    public int[] travel(TreeNode root){
        if(root ==null){
            return new int[2];
        }
        int[] left_choise = travel(root.left);
        int[] right_choise = travel(root.right);
        int[] options = new int[2];
        options[0] = root.val+left_choise[1]+right_choise[1];
        options[1] = Math.max(left_choise[0], left_choise[1])+
        Math.max(right_choise[0], right_choise[1]);
        return options;
    }
}