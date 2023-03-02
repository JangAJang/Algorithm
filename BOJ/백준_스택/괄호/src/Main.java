import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack{
    char[] arr = new char[51];
    int count = 0;

    Stack(){}

    void push(char c){
        count++;
        arr[count] = c;
    }

    void pop(){
        arr[count] = 0;
        count--;
    }

    int getCount(){
        return count;
    }

    char former(){
        return arr[count];
    }
}

public class Main{

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String s = br.readLine();
            Stack my = new Stack();
            my.push(s.charAt(0));
            for(int j=1; j<s.length(); j++){
                if(my.former()=='(' && s.charAt(j)==')'){
                    my.pop();
                    continue;
                }
                else my.push(s.charAt(j));
            }
            if(my.getCount()==0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}