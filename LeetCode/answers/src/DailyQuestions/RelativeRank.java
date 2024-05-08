package DailyQuestions;

public class RelativeRank {

    class Solution {
        public String[] findRelativeRanks(int[] score) {
            int n = score.length;
            String[] result = new String[n];

            // 우선순위 큐를 사용하여 점수를 내림차순으로 정렬
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> scoreIndexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                pq.offer(score[i]);
                scoreIndexMap.put(score[i], i);
            }

            // 상위 세 명에 대해 랭크를 부여
            String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
            for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                int topScore = pq.poll();
                int index = scoreIndexMap.get(topScore);
                result[index] = medals[i];
            }

            // 나머지 선수들에 대해 랭크를 부여
            int rank = 4;
            while (!pq.isEmpty()) {
                int topScore = pq.poll();
                int index = scoreIndexMap.get(topScore);
                result[index] = String.valueOf(rank++);
            }

            return result;
        }
    }
}
