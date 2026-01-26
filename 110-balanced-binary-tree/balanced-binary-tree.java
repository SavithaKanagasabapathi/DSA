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
    public boolean isBalanced(TreeNode root) {
        //TC-O(N) and SC-O(H), height of recursion stack
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;//If null, return true
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1) {//If any left or right node height diff is >1
            return -1;//way to give negative value to return false
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {//math.abs gives +ve for -ve also
            //If balanced tree, Math.abs(left-right)<=1
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;//Height rule
    }
}