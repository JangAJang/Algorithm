public class main {
    public static void main(String[] args){
        int[] A = new int [200];
        for(int i=0; i<200; i++){
            A[i] = (int)(Math.random()*100);
        }
        for(int i=0; i<10; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }
}
