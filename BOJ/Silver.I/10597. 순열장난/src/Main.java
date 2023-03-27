import java.io.*;

public class Main {
    private static boolean[] visited;
    private static String numbers;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[51];
        numbers = br.readLine();
        dfs(0, 0, "");
    }

    private static void dfs(int index, int n, String result){
        if(index == numbers.length()){
            if(isNotVisitedAll(n)) return;
            System.out.println(result.trim());
            System.exit(0);
        }
        moveToNextDfsWithOneNumber(index, n, result);
        moveToNextDfsWithTwoNumber(index, n, result);
    }

    private static void moveToNextDfsWithOneNumber(int index, int n, String result){
        int current = numbers.charAt(index)-'0';
        if(!visited[current]){
            visited[current] = true;
            dfs(index+1, Math.max(current, n), result + " " + current);
            visited[current] = false;
        }
    }

    private static void moveToNextDfsWithTwoNumber(int index, int n, String result){
        if(index < numbers.length()-1){
            int current = Integer.parseInt(numbers.substring(index, index+2));
            if(current < 51 && !visited[current]){
                visited[current] = true;
                dfs(index+2, Math.max(current, n), result + " " + current);
                visited[current] = false;
            }
        }
    }

    private static boolean isNotVisitedAll(int n){
        for(int index = 1; index <=n; index++){
            if(!visited[index]) return true;
        }
        return false;
    }
}