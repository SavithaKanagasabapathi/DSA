/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    //TC-O(N) and SC-O(N), recursion stack for both serialize and deserialize
    //preorder traversal

    private static final String NULL_KEYWORD = "NULL";
    private static final String DELIMITER = ", ";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_KEYWORD).append(DELIMITER);
            return;
        }
        sb.append(root.val).append(DELIMITER);
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(data.split(DELIMITER)));
        return deserializeHelper(deque);
    }

    private TreeNode deserializeHelper(Deque<String> deque) {
        String node = deque.poll();
        if (node.equals(NULL_KEYWORD)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserializeHelper(deque);
        root.right = deserializeHelper(deque);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));