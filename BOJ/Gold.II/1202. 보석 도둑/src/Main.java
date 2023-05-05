import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int jewelCount = Integer.parseInt(st.nextToken());
        int bagCount = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[jewelCount];
        long[] bags = new long[bagCount];
        for(int index = 0; index < jewelCount; index++){
            st = new StringTokenizer(br.readLine(), " ");
           jewels[index] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int index = 0; index < bagCount; index++){
            bags[index] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel jewel, Jewel t1) {
                if(jewel.getWeight() == t1.getWeight()) return t1.getValue() - jewel.getValue();
                return jewel.getWeight() - t1.getWeight();
            }
        });
        Arrays.sort(bags);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0L;
        for(int index = 0, jewelIndex = 0; index < bagCount; index++){
            while(jewelIndex < jewelCount && bags[index] >= jewels[jewelIndex].getWeight()){
                pq.offer(jewels[jewelIndex++].getValue());
            }
            if(!pq.isEmpty()) result += pq.poll();
        }
        System.out.println(result);
    }

    static class Jewel{
        private final int value;
        private final int weight;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }
    }
}