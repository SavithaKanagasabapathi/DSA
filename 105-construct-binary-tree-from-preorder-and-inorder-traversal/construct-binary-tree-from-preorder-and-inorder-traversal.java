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
    //TC-O(N) and SC-O(N), hashmap and recursion stack
    //preorder-root,left,right
    //inorder-left,root,right
    int preorderIndex;
    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = IntStream.range(0, inorder.length)
                .boxed().collect(Collectors.toMap(i -> inorder[i], i -> i));
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int start, int end) {
        if (start <= end) {
            int rootValue = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootValue);
            int mid = inorderMap.get(rootValue);
            root.left = arrayToTree(preorder, start, mid - 1);
            root.right = arrayToTree(preorder, mid + 1, end);
            return root;
        }
        return null;
    }
}