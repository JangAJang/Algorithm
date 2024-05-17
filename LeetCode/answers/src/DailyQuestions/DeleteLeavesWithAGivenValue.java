package DailyQuestions;

public class DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root.left != null) root.left = removeLeafNodes(root.left, target);
        if(root.right != null) root.right = removeLeafNodes(root.right, target);
        if(root.val == target && isLeafNode(root)) return null;
        return root;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
