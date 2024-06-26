package DailyQuestions;

public class BalanceABinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorderTraversal(root, nodes);

        // Step 2: Build balanced BST from sorted nodes
        return sortedArrayToBST(nodes, 0, nodes.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }

    private TreeNode sortedArrayToBST(List<Integer> nodes, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));

        node.left = sortedArrayToBST(nodes, left, mid - 1);
        node.right = sortedArrayToBST(nodes, mid + 1, right);

        return node;
    }
}
