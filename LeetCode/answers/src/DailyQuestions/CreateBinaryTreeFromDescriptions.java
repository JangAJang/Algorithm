package DailyQuestions;

public class CreateBinaryTreeFromDescriptions {

    private Map<Integer, Integer> parent;

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        parent = new HashMap<>();
        for(int[] each : descriptions) {
            TreeNode root = map.getOrDefault(each[0], new TreeNode(each[0]));
            TreeNode leaf = map.getOrDefault(each[1], new TreeNode(each[1]));
            appendLeaf(root, leaf, each[2]);

            map.put(each[0], root);
            map.put(each[1], leaf);
            union(each[0], each[1]);
        }

        return map.get(find(parent.keySet().iterator().next()));
    }

    private void appendLeaf(TreeNode root, TreeNode leaf, int val) {
        if(val == 0) {
            root.right = leaf;
            return;
        }

        root.left = leaf;
    }

    private int find(int value) {
        int parentValue = parent.getOrDefault(value, value);
        if(value == parentValue) {
            parent.put(value, parentValue);
            return parentValue;
        }

        parent.put(value, find(parentValue));
        return parent.get(value);
    }

    private void union(int root, int val) {
        root = find(root);
        val = find(val);
        parent.put(val, root);
    }
}
