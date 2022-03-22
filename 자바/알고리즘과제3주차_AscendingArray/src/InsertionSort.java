public class InsertionSort {
    public static void main(String[] args){
        long start = System.nanoTime();
        int[] B = new int[200];
        for(int i=0; i<200; i++){
            B[i] = i+1;
        }
        insertSort(B, 1);
        long end = System.nanoTime();
        System.out.println(end-start);
    }


    static void insertSort(int[] A, int n){
        if(n == A.length) return ;
        for(int i=0; i<n; i++){
            if(A[i] > A[n]){
                int tmp = A[n];
                A[n] = A[i];
                A[i] = tmp;
            }
        }
        insertSort(A, n+1);
    }
}
