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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //TC-O(N) and SC-O(H), H is logn for complete, n for skewed - recursion depth
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {//Check if leaf node val==remaining target sum
            return targetSum == root.val;
        }
        int remainingTargetSum = targetSum - root.val;
        return hasPathSum(root.left, remainingTargetSum) || hasPathSum(root.right, remainingTargetSum);
    }
}