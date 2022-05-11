import java.util.Random;

public class no4{
    static int search;
    static int crash;

    public static int hashInsert(int[] arr, int x) {
        int i = 0;
        while (i < 31) {
            search++;
            int j = x % 31;
            if (arr[(j + i) % 31] == 0) {
                arr[(j + i) % 31] = x;
                return (j + i) % 31;
            } else {
                i++;
                crash++;
            }
        }
        return -1;
    }

    public static int hashSearch(int[] arr, int x) {
        int i = 0;
        while (i < 31) {
            search++;
            int j = x % 31;
            if (arr[(j + i + 31) % 31] == x) {
                return (j + i) % 31;
            } else {
                i++;
                crash++;
            }
        }
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
