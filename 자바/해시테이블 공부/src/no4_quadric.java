import java.util.Random;

public class no4_quadric{
    static int crash;
    static int search;
    static int hashInsert(int[] arr, int x){
        int i=0;
        do{
            search++;
            int j = x%31;
            if(arr[(j+(i * i))%31] == 0){
                arr[(j+(i * i))%31] = x;
                return (j+(i*i))%31;
            }
            else i++;
            crash = i;
        }while(i != 31);
        return -1;
    }

    static int hashSearch(int[] arr, int x){
        int i=0;
        int j;
        do{
            search++;
            j = x % 31;
            if(arr[(j+(i*i))%31] == x){
                return (j+(i*i))%31;
            }
            else i++;
            crash = i;
        }while(arr[(j+(i*i))%31] != 0 || i != 31);
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[31];
        Random ran = new Random();
        int location;
        int num;
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            crash = 0;
            search = 0;
            num = ran.nextInt(Integer.MAX_VALUE);
            location = hashInsert(arr, num);
            System.out.println((i + 1) + " : " + num + " is in " + location + ", Crash occured " + crash + " times.");
            sum += crash;
        }
        System.out.println("총 충돌횟수 : " + sum);
    }
}
