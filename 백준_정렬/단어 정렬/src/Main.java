import com.sun.jdi.event.ExceptionEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)throws IOException, Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] words = new String[T];
        for(int i=0; i<T; i++){
            words[i] = br.readLine();
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer.compare(o1.length(), o2.length());
                if(o1.length() == o2.length()){
                    for(int i=0; i<o1.length(); i++){
                        if(o1.charAt(i) != o2.charAt(i)) return Character.compare(o1.charAt(i), o2.charAt(i));
                        else continue;
                    }
                }
                return Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println(words[0]);
        for(int i=1; i<T; i++){
            if(!words[i].equals(words[i-1])) {System.out.println(words[i]);}
        }
    }
}
