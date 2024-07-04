package DailyQuestions;

public class MergeNodesInBetweenZeros {

    public ListNode mergeNodes(ListNode head) {

        List<Integer> list = new ArrayList<>();

        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        List<Integer> addedValue = new ArrayList<>();
        int current = 0;

        for(int each : list) {
            if(each == 0) {
                addedValue.add(current);
                current = 0;
                continue;
            }

            current += each;
        }

        System.out.println(addedValue.toString());
        ListNode before = null;

        for(int index = addedValue.size()-1; index >= 1; index--) {
            before = new ListNode(addedValue.get(index), before);
        }

        return before;
    }
}
