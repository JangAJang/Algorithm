import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Set<String> list = new HashSet<>();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String[] vowels = new String[]{"a", "e", "i", "o", "u"};
    private static int limit;
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        limit = Integer.parseInt(st.nextToken());
        int alphabet = Integer.parseInt(st.nextToken());
        String[] alphabets = br.readLine().split(" ");
        Arrays.sort(alphabets);
        for(int index = 0; index <= alphabet - limit; index++){
            makePassword(index, alphabets, new StringBuilder(alphabets[index]));
        }
        for(String each : list.stream().sorted().collect(Collectors.toList())){
            System.out.println(each);
        }
    }

    private static void makePassword(int index, String[] alphabets, StringBuilder sb){
        if(sb.length() == limit){
            if(isCapable(sb)) list.add(sb.toString());
            return;
        }
        for(int next = index+1; next <= alphabets.length - (limit - sb.length()); next++){
            sb.append(alphabets[next]);
            makePassword(next, alphabets, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private static boolean isCapable(StringBuilder sb){
        int count = 0;
        for( String each : sb.toString().split("")){
            for(String vowel : vowels){
                if(each.equals(vowel)) count++;
            }
        }
        return count >=1 && (sb.length()-count) >=2;
    }
}