public class selectionSort{
    public static void main(String[] args){
        int[] A = new int[200];
        for(int i=0; i<200; i++){
            A[i] = (int)(Math.random()*1000);
        }
        long start = System.nanoTime();
        selectionSort(A, 200);
        long end = System.nanoTime();
        System.out.println(A[99]);
        System.out.println((end - start));
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