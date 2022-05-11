import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        char alpha = 'a';
        int location=0;
        for(int i=0; i<26; i++){
            boolean check = false;
            for(int j=0; j<S.length(); j++){
                if((alpha+i) == S.charAt(j)) {check = true; location = j; break;}
            }
            if( check == true) bw.write(location + " ");
            if(check == false )bw.write("-1 ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
