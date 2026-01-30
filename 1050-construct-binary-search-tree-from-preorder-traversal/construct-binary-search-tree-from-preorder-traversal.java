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
    //preorder is i/p, if we sort it - inorder will come, so tree from inorder and preorder sum 
    //we already covered but it's TC will be O(nlogn) as we are using sorting

    //TC-O(N) and SC-O(H), recursion stack
    //preorder-root,left,right
    //BST-left<root<right
    int preorderIndex = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return arrayToTree(preorder, Integer.MAX_VALUE);
    }

    private TreeNode arrayToTree(int[] preorder, int max) {
        if (preorderIndex < preorder.length && preorder[preorderIndex] < max) {
            TreeNode root = new TreeNode(preorder[preorderIndex++]);
            root.left = arrayToTree(preorder, root.val);//left tree will be less than root
            root.right = arrayToTree(preorder, max);//right tree will be greater than root
            return root;
        }
        return null;
    }
}