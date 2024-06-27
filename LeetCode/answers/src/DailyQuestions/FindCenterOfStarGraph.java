package DailyQuestions;

public class FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {
        int[] arr = new int[edges.length + 2];

        for(int[] edge : edges) {
            arr[edge[0]]++;
            arr[edge[1]]++;
        }

        int max = 0;
        int maxIndex = 0;

        for(int index = 0; index < arr.length; index++) {
            if(max < arr[index]) {
                max = arr[index];
                maxIndex = index;
            }
        }

        return maxIndex;
    }
}
