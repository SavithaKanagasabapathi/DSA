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
    public int diameterOfBinaryTree(TreeNode root) {
        //TC-O(N) and SC-O(H), H is logn for complete, n for skewed - recursion depth
        return getHeightDiameter(root)[1];
    }

    private int[] getHeightDiameter(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }
        int[] left = getHeightDiameter(node.left);
        int[] right = getHeightDiameter(node.right);
        int height = Math.max(left[0], right[0]) + 1;
        int diameter = Math.max(left[0] + right[0], Math.max(left[1], right[1]));
        //height=max(height(left), height(right))+1
        //diameter=max(height(left)+height(right) and max(diameter(left), diameter(right)))
        return new int[] { height, diameter };
    }
}