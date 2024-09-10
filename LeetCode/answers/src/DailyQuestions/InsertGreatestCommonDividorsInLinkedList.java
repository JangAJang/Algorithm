package DailyQuestions;

public class InsertGreatestCommonDividorsInLinkedList {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;
        while(node.next != null) {
            ListNode current = node;
            ListNode next = node.next;
            final int max = Math.max(current.val, next.val);
            final int min = Math.min(current.val, next.val);
            ListNode newNode = new ListNode(getGCD(max, min), next);
            current.next = newNode;
            node = next;
        }

        return head;
    }

    private int getGCD(final int a, final int b) {
        if(b == 0) {
            return a;
        }

        return getGCD(b, a%b);
    }
}
