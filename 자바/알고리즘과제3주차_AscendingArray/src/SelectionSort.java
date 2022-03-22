public class SelectionSort {
    public static void main(String[] args){
        long start = System.nanoTime();
        int[] B = new int[200];
        for(int i=0; i<200; i++){
            B[i] = i+1;
        }
        selectionSort(B, 200);
        long end = System.nanoTime();
        System.out.println(end-start);
    }

    static void selectionSort(int[] A, int n){
        if(n==1) return;
        int max=0;
        int location=0;
        for(int i=n-1; i>=0; i--){
            if(A[i] > max) {
                max = A[i];
                location = i;
            }
        }
        A[location] = A[n-1];
        A[n-1] = max;
        selectionSort(A, n-1);
    }
}
