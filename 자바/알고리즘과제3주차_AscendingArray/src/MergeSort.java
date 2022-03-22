public class MergeSort {
    static int[] B = new int[200];
    static int[] tmp = new int [200];
    public static void main(String[] args){
        long start = System.nanoTime();
        for(int i=0; i<200; i++){
            B[i] = i+1;
        }
        mergeSort(0, 199);
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

    public static void merge(int start, int mid, int end) {
        int p = start;
        int q = mid + 1;
        int idx = p;
        while (p <= mid || q <= end) {
            if (q > end || (p <= mid && B[p] < B[q])) {
                tmp[idx++] = B[p++];
            } else {
                tmp[idx++] = B[q++];
            }
        }
        for (int i = start; i <= end; i++) {
            B[i] = tmp[i];
        }
    }
}
