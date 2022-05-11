import java.util.Random;

public class no6{
    static int crash;
    static int search;
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
        double avg_for_case = 0;
        for(int count = 0; count<1000; count++) {
            Random ran = new Random();
            int[] nums = new int[20];
            int location;
            int num;
            int[] arr = new int[31];
            double sum_for_crash = 0;
            for (int i = 0; i < 20; i++) {
                crash = 0;
                search = 0;
                num = ran.nextInt(1000);
                nums[i] = num;
                location = hashInsert(arr, num);
                avg_for_case += crash;
            }
        }
        System.out.println(avg_for_case  / 2000);
    }
}
