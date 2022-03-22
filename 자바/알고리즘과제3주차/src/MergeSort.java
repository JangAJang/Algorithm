public class MergeSort {
    public static int[] A;
    public static int[] tmp;
    public static void main(String[] args) {
        long start = System.nanoTime();
        A = new int[200];
        for(int i=0; i<200; i++){
            A[i] = (int)(Math.random()*100);
        }
        tmp = new int[A.length];
        mergeSort(0, A.length-1);
        System.out.println(A[102]);
        long end = System.nanoTime();
        System.out.println(end-start);
    }

    public static void mergeSort(int start, int end) {
        if (start<end) {
            int mid = (start+end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, mid, end);
        }
    }

    public static void merge(int start, int mid, int end){
        int p = start;
        int q = mid + 1;
        int idx = p;
        while (p<=mid || q<=end) {
            if (q>end || (p<=mid && A[p]<A[q])) {
                tmp[idx++] = A[p++];
            }
            else {
                tmp[idx++] = A[q++];
            }
        }
        for (int i=start;i<=end;i++) {
            A[i]=tmp[i];
        }
    }
}
