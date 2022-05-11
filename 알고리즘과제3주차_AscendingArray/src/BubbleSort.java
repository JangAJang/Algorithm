public class BubbleSort {
    public static void main(String[] args){
        long start = System.nanoTime();
        int[] B = new int[200];
        for(int i=0; i<200; i++){
            B[i] = i+1;
        }
        for(int i=199; i>=1; i--){
            for(int j=0; j<i; j++){
                if(B[j] > B[j+1]){
                    int tmp = B[j+1];
                    B[j+1] = B[j];
                    B[j] = tmp;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
