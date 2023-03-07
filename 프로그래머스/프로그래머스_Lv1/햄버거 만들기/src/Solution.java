import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    private static final String HAMBURGER = "1231";
    private String table = "";
    private int count = 0;

    public int solution(int[] ingredient) {
        makeBurger(ingredient);
        return count;
    }

    private void makeBurger(int[] ingredient){
        StringBuilder table = new StringBuilder();
        for(int i=0; i< ingredient.length; i++){
            table.append(ingredient[i]);
            deleteFromTableIfBurger(table);
        }
    }

    private void deleteFromTableIfBurger(StringBuilder table){
        if(table.length() > 3 && table.subSequence(table.length()-4, table.length()).equals(HAMBURGER)){
            count++;
            table.delete(table.length()-4, table.length());
        }
    }
}