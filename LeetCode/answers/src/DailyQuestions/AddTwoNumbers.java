import java.util.*;

class  AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ascender = 0;
        while(l1 != null || l2 != null || ascender != 0) {
            int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + ascender;
            deque.addLast(value % 10);
            ascender = value / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        ListNode answer = null;
        while(!deque.isEmpty()) {
            answer = new ListNode(deque.removeLast(), answer);
        }
        return answer;
    }
}
