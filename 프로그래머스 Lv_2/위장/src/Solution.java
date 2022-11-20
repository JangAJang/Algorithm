import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    private final HashMap<String, List<String>> categoryMap = new HashMap<>();
    private static final int CATEGORY_INDEX = 1;
    private static final int CLOTHES_INDEX = 0;

    public int solution(String[][] clothes) {
        categorizeClothes(clothes);
        return countTotalPossibilities();
    }

    private int countTotalPossibilities(){
        int result = 1;
        for(String category : categoryMap.keySet()){
            result *= (categoryMap.get(category).size()+1);
        }
        return result - 1;
    }

    private void categorizeClothes(String[][] clothes){
        for(int index = 0; index < clothes.length; index++){
            categorizeEach(clothes[index]);
        }
    }

    private void categorizeEach(String[] clothEach){
        if(categoryMap.containsKey(clothEach[CATEGORY_INDEX])) {
            categoryMap.get(clothEach[CATEGORY_INDEX]).add(clothEach[CLOTHES_INDEX]);
            return;
        }
        List<String> closet = new ArrayList<>();
        closet.add(clothEach[CLOTHES_INDEX]);
        categoryMap.put(clothEach[CATEGORY_INDEX], closet);
    }
}