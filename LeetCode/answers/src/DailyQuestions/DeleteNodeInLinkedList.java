package DailyQuestions;

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        while(true) {
            node.val = node.next.val;
            if(node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
    }
}
