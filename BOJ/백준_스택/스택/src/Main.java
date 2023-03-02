import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] a = new long[N];
        StringTokenizer st;
        int count = -1;
        for(int i = 0; i<N; i++){
            String command = br.readLine();
            if(command.contains("push")){
                String[] div = command.split(" ");
                ++count;
                a[count] = Long.parseLong(div[1]);
                }
            else if(command.contains("pop")){
                if(count==-1)bw.write("-1");
                else {
                    bw.write(Long.toString(a[count]));
                    count--;
                }
                bw.write("\n");
            }
            else if(command.contains("size")){
                bw.write(Integer.toString(count+1));
                bw.write("\n");
            }
            else if(command.contains("empty")){
                if(count == -1) bw.write("1");
                else bw.write("0");
                bw.write("\n");
            }
            else if(command.contains("top")){
                if(count == -1 ) bw.write("-1");
                else bw.write(Long.toString(a[count]));
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
        }
    }
