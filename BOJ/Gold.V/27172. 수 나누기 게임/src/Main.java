import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int SIZE = 1_000_001;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] player = new int[n];
        boolean[] card = new boolean[SIZE];
        int[] score = new int[SIZE];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int index = 0; index < n; index++) {
            player[index] = Integer.parseInt(st.nextToken());
            card[player[index]] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int index : player) {
            for(int value = index * 2; value < SIZE; value += index) {
                if(card[value]){
                    ++ score[index];
                    -- score[value];
                }
            }
        }
        for (int num : player)
            sb.append(score[num]).append(' ');

        System.out.println(sb.toString());
    }
}

//class Card {
//    private int score;
//    private final int value;
//    private final boolean[] dividable;
//
//    public Card(int value) {
//        this.value = value;
//        dividable = new boolean[value+1];
//        for(int index = 2; index * index <= value; index++) {
//            if(value % index == 0) {
//                dividable[index] = true;
//                dividable[value / index] = true;
//            }
//        }
//    }
//
//    public boolean isDividedBy(final int divider) {
//        if(divider >= value) return false;
//        return dividable[divider];
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void increaseScore() {
//        this.score++;
//    }
//
//    public void decreaseScore() {
//        this.score--;
//    }
//
//    public void calculateScore(final Card card) {
//        if(isDividedBy(card.getValue())) {
//            decreaseScore();
//            card.increaseScore();
//        }
//
//        if(card.isDividedBy(value)) {
//            card.decreaseScore();
//            increaseScore();
//        }
//    }
//}