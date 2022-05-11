public class insertionSort {
    public static void main(String[] args){
        int[] A = new int [20000];
        for(int i=0; i<20000; i++){
            A[i] = (int)(Math.random()*100000);
        }
        long start = System.currentTimeMillis();
        insertSort(A, 1);
        long end = System.currentTimeMillis();
        System.out.println(A[101]);
        System.out.println(end - start);
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
