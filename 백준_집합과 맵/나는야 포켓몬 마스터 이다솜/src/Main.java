import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> pokemon = new HashMap<>();
        HashMap<String, Integer> pokemon_for_number = new HashMap<>();
        for(int i=0; i<N; i++){
            String name = br.readLine();
            pokemon.put(i+1, name);
            pokemon_for_number.put(name, i+1);
        }
        for(int i=0; i<M; i++){
            String quiz = br.readLine();
            if(quiz.charAt(0) >= 'A' && quiz.charAt(0) <= 'Z'){
                System.out.println(pokemon_for_number.get(quiz));
            }
            else{
                System.out.println(pokemon.get(Integer.parseInt(quiz)));
            }
        }
    }
}
