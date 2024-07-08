package DailyQuestions;

public class FindTheWinnerOfTheCircularGame {

    public int findTheWinner(int n, int k) {
        final Queue<Integer> queue = createCircular(n);

        while(queue.size() > 1) {
            for(int index = 0; index < k-1; index++) {
                queue.add(queue.poll());
            }

            queue.poll();
        }

        return queue.peek();
    }

    private Queue<Integer> createCircular(final int n) {
        final Queue<Integer> queue = new ArrayDeque<>();

        for(int index = 1; index <= n; index++) {
            queue.add(index);
        }

        return queue;
    }
}
