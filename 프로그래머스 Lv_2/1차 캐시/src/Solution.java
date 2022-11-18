import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private final Deque<String> cache = new ArrayDeque<>();
    private int executionTime = 0;

    public int solution(int cacheSize, String[] cities) {
        return countTime(cities, cacheSize);
    }

    private int countTime(String[] cities, int cacheSize){
        for(String city : cities){
            addNextCity(city.toLowerCase(), cacheSize);
        }
        return executionTime;
    }

    private void addNextCity(String city, int cacheSize){
        if(cache.contains(city)) {
            cacheHit(city);
            return;
        }
        cacheMiss(city, cacheSize);
    }

    private void cacheHit(String city){
        cache.remove(city);
        cache.addLast(city);
        executionTime++;
    }

    private void cacheMiss(String city, int cacheSize){
        cache.addLast(city);
        while(cache.size() > cacheSize){
            cache.pollFirst();
        }
        executionTime += 5;
    }
}