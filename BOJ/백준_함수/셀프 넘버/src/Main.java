public class Main {
    public static void main(String[] args){
        for(int i=1; i<=10000; i++){
            boolean check = false;
            for(int j=1; j<= 10000; j++){
                if(i == d(j)) check = true;
            }
            if(check == false) System.out.println(i);
        }
    }

    public static int d(int a){
        int deed=0, tmp = a;
        if( a < 10 && a> 0) deed = a + a%10;
        if(a >= 10 && a < 100) deed = a + a%10 + a/10;
        if( a>=100 & a<1000) deed = a+ a/100 + (a/10)%10 + a%10;
        if( a>= 1000 && a< 10000) deed = a+a/1000 + (a/100)%10 + (a%100)/10 + a%10;
        if( a== 10000) deed = 10001;
        return deed;
    }
}
