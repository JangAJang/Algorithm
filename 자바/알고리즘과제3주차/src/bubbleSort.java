public class bubbleSort {
    public static void main(String[] args){
        long start = System.nanoTime();
        int[] A = new int [200];
        for(int i=0; i<200; i++){
            A[i] = (int)(Math.random()*100);
        }
        for(int i=199; i>=1; i--){
            for(int j=0; j<i; j++){
                if(A[j] > A[j+1]){
                    int tmp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = tmp;
                }
            }
        }
        System.out.println(A[100]);
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
