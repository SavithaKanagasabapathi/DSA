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
    //postorder-left,right,root
    //inorder-left,root,right
    int postorderIndex;
    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;//last index
        inorderMap = IntStream.range(0, inorder.length)
                .boxed().collect(Collectors.toMap(i -> inorder[i], i -> i));
        return arrayToTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int start, int end) {
        if (start <= end) {
            int rootValue = postorder[postorderIndex--];//decrement
            TreeNode root = new TreeNode(rootValue);
            int mid = inorderMap.get(rootValue);
            root.right = arrayToTree(postorder, mid + 1, end);//first right then left
            root.left = arrayToTree(postorder, start, mid - 1);
            return root;
        }
        return null;
    }
}