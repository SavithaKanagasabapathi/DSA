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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //TC-O(N) and SC-O(W), w is the width of the tree stored in queue for each level
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean leftToRight = true;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelVals = new LinkedList<>();//LinkedList O(1) for adding in front
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (leftToRight) {
                    levelVals.add(node.val);//LeftToRight
                } else {
                    levelVals.addFirst(node.val);//RightToLeft
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            result.add(levelVals);
            leftToRight = !leftToRight;//Change boolean
        }
        return result;
    }
}