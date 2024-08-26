package DailyQuestions;

public class NaryTreePostorderTraversal {

    private List<Integer> answer;

    public List<Integer> postorder(Node root) {
        if(root == null) return new ArrayList<>();
        answer = new ArrayList<>();
        addPostorder(root);
        return answer;
    }

    private void addPostorder(final Node node) {
        if(node.children != null) {
            node.children.forEach(child -> addPostorder(child));
        }

        answer.add(node.val);
    }
}
