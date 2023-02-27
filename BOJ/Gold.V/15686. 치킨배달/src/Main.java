import java.util.*;
import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        List<int[]> stores = new ArrayList<>();
        List<int[]> houses = new ArrayList<>();
        for(int x = 0; x < N; x++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int y = 0; y < N; y++){
                int v = Integer.parseInt(st.nextToken());
                if(v == 0) continue;
                if(v == 1) {
                    houses.add(new int[]{x, y});
                    continue;
                }
                stores.add(new int[]{x, y});
            }
        }
        int[][] distance = new int[stores.size()][houses.size()];
        int[] arr = new int[stores.size()];
        for(int storeIndex = 0; storeIndex < stores.size(); storeIndex++){
            arr[storeIndex] = storeIndex;
            for(int houseIndex = 0; houseIndex < houses.size(); houseIndex++){
                int[] store = stores.get(storeIndex);
                int[] house = houses.get(houseIndex);
                distance[storeIndex][houseIndex] = Math.abs(store[0] - house[0]) + Math.abs(store[1] - house[1]);
            }
        }
        combination(arr, new boolean[stores.size()], 0, stores.size(), limit, distance);
        System.out.println(answer);
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r, int[][] distance) {
        if(r == 0) {
            calc(arr, visited, distance);
            return;
        }
        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, distance);
            visited[i] = false;
        }
    }

    private static void calc(int[] arr, boolean[] visited, int[][] distance){
        int[] result = new int[distance[0].length];
        Arrays.fill(result, Integer.MAX_VALUE);
        for(int index = 0; index < arr.length; index++){
            if(!visited[index]) continue;
            for(int house = 0; house < result.length; house++){
                result[house] = Math.min(result[house], distance[index][house]);
            }
        }
        answer = Math.min(answer, Arrays.stream(result).sum());
    }
}