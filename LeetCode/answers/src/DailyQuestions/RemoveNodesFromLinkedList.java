package DailyQuestions;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveNodesFromLinkedList {

    public ListNode removeNodes(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        while(head != null) {
            if(deque.isEmpty() || deque.getFirst() >= head.val) {
                deque.addFirst(head.val);
                head = head.next;
                continue;
            }

            while(!deque.isEmpty() && deque.getFirst() < head.val) {
                deque.removeFirst();
            }
            deque.addFirst(head.val);
            head = head.next;
        }

        ListNode root = new ListNode(deque.removeFirst());
        while(!deque.isEmpty()) {
            root = new ListNode(deque.removeFirst(), root);
        }
        return root;
    }
}
