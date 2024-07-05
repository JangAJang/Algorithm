package DailyQuestions;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int count = 0;

        while(head.next.next != null) {
            count++;
            int left = head.val;
            int mid = head.next.val;
            int right = head.next.next.val;

            if(mid > left && mid > right) {
                list.add(count);
            }

            if(mid < left && mid < right) {
                list.add(count);
            }

            head = head.next;
        }

        if(list.size() < 2) return new int[]{-1, -1};

        int minimum = Integer.MAX_VALUE;

        for(int index = 0; index < list.size()-1; index++) {
            minimum = Math.min(minimum, list.get(index+1) - list.get(index));
        }

        return new int[]{minimum, list.get(list.size()-1) - list.get(0)};
    }
}
