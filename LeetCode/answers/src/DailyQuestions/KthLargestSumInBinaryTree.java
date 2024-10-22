package DailyQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class KthLargestSumInBinaryTree {

    public long kthLargestLevelSum(TreeNode root, int k) {
        final List<Long> sum = getLevelSums(root);
        if(sum.size() < k) return -1;
        sum.sort(Collections.reverseOrder());
        return sum.get(k-1);
    }

    private List<Long> getLevelSums(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        final List<Long> result = new ArrayList<>();

        while(!list.isEmpty()) {
            result.add(list.stream().mapToLong(node -> node.val).sum());
            final List<TreeNode> left = new ArrayList<>(list.stream().map(node -> node.left).filter(Objects::nonNull).toList());
            final List<TreeNode> right = list.stream().map(node -> node.right).filter(Objects::nonNull).toList();
            left.addAll(right);
            list = left;
        }

        return result;
    }
}
