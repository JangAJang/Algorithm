package DailyQuestions;

public class CrawlerLogFolder {

    public int minOperations(String[] logs) {
        Deque<String> deque = new ArrayDeque<>();

        for(String log : logs) {
            if(log.equals("./")) continue;

            if(log.equals("../")) {
                if(deque.isEmpty()) continue;
                deque.pop();
                continue;
            }

            deque.push(log);
        }

        return deque.size();
    }
}
