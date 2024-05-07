package DailyQuestions;

public class DoubleANumberRepresentedAsALinkedList {

    public ListNode doubleIt(ListNode head) {
        int upper = multiply(head);
        if(upper == 0) return head;
        return new ListNode(upper, head);
    }

    private int multiply(ListNode node) {
        if(node.next == null) {
            int value = node.val * 2;
            node.val = value % 10;
            return value / 10;
        }

        int upper = multiply(node.next);
        int value = node.val * 2;
        node.val = value % 10 + upper;
        return value / 10;
    }
}
