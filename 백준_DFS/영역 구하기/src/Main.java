import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] xMove = new int[]{-1, 1, 0, 0};
    private static final int[] yMove = new int[]{0, 0, -1, 1};

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int squares = Integer.parseInt(st.nextToken());
        int[][] field = makeField(new int[x][y], squares);
        visited = new boolean[x][y];
        countAreas(x, y, field);
    }

    private static int[][] makeField(int[][] field, int squares)throws IOException{
        StringTokenizer st;
        while(squares-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for(int xIndex = startX; xIndex < endX; xIndex++){
                for(int yIndex = startY; yIndex < endY; yIndex++){
                    field[xIndex][yIndex] = 1;
                }
            }
        }
        return field;
    }

    private static void countAreas(int x, int y, int[][] field){
        int result = 0;
        List<Integer> areaSize = new ArrayList<>();
        for(int xIndex = 0; xIndex < x; xIndex++){
            for(int yIndex = 0; yIndex < y; yIndex++){
                if(field[xIndex][yIndex] == 0 && !visited[xIndex][yIndex]){
                    areaSize.add(countAreasByDFS(field, new int[]{xIndex, yIndex}, 1));
                    result++;
                }
            }
        }
        System.out.println(result);
        System.out.println(areaSize.stream().sorted().map(i -> Integer.toString(i)).collect(Collectors.joining(" ")));
    }

    private static int countAreasByDFS(int[][] field, int[] location, int size){
        if(field[location[0]][location[1]] == 1) return size;
        if(visited[location[0]][location[1]]) return size;
        visited[location[0]][location[1]] = true;
        for(int index = 0; index < 4; index++){
            int nextX = location[0] + xMove[index];
            int nextY = location[1] + yMove[index];
            if(nextX < 0 || nextX >= field.length) continue;
            if(nextY < 0 || nextY >= field[0].length) continue;
            if(field[nextX][nextY] == 1) continue;
            if(visited[nextX][nextY]) continue;
            size = countAreasByDFS(field, new int[]{nextX, nextY}, size+1);
        }
        return size;
    }
}