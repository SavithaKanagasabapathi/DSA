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
    public boolean isCousins(TreeNode root, int x, int y) {
        //TC-O(N) and SC-O(W), W-width of tree (complete-N/2, skewed-N)
        if (root != null) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                boolean xFound = false, yFound = false;
                int size = deque.size();//size is changing inside loop, so set size in variable, 
                //don't add directly in for loop
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    if (node.val == x) {
                        xFound = true;
                    }
                    if (node.val == y) {
                        yFound = true;
                    }
                    if (node.left != null && node.right != null) {
                        if ((node.left.val == x && node.right.val == y) ||
                                (node.left.val == y && node.right.val == x)) {
                            return false;//siblings check
                        }
                    }
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                }
                if (xFound && yFound) {
                    return true;//Both found in same level
                }
                if (xFound || yFound) {
                    return false;//Both found in different level or only one found
                }
            }
        }
        return false;
    }
}