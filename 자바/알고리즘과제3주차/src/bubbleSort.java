public class bubbleSort {
    public static void main(String[] args){
        int[] A = new int [20000];
        for(int i=0; i<20000; i++){
            A[i] = (int)(Math.random()*100000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(A);
        long end = System.currentTimeMillis();
        System.out.println(A[100]);
        System.out.println(end - start);
    }

    static void bubbleSort(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j= 1 ; j < arr.length-i; j++) {
                if(arr[j]<arr[j-1]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}