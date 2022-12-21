import java.util.*;

class Solution {

    private Deque<Integer> stocks;

    public int[] solution(int[] prices) {
        stocks = saveStocks(prices);
        List<Integer> timeOfPriceStable = new ArrayList<>();
        while(!stocks.isEmpty()){
            timeOfPriceStable.add(getPriceSavingTime());
        }
        return timeOfPriceStable.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getPriceSavingTime(){
        int stockEach = stocks.pollFirst();
        if(stocks.isEmpty()) return 0;
        int count = 0;
        for(int priceEach : stocks){
            count++;
            if(priceEach < stockEach) return count;
        }
        return count;
    }

    private Deque<Integer> saveStocks(int[] prices){
        Deque<Integer> stocks = new ArrayDeque<>();
        for (int price : prices) {
            stocks.add(price);
        }
        return stocks;
    }
}