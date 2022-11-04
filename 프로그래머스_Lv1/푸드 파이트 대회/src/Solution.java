class Solution {
    public String solution(int[] food) {
        return setFoodOnTable(food);
    }

    private String setFoodOnTable(int[] food){
        String table = "0";
        for(int kcalIndex = food.length-1; kcalIndex > 0; kcalIndex--){
            String portion = makePortion(food[kcalIndex], kcalIndex);
            table = portion.concat(table).concat(portion);
        }
        return table;
    }

    private int getFoodCountForEach(int foodCount){
        return foodCount /2;
    }

    private String makeFoodToString(int kcal, int halfOfFoodCount){
        return String.valueOf(kcal).repeat(Math.max(0, halfOfFoodCount));
    }

    private String makePortion(int foodCount, int kcal){
        return makeFoodToString(kcal, getFoodCountForEach(foodCount));
    }

}