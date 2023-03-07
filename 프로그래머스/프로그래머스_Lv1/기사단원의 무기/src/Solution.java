class Solution {
    public int solution(int number, int limit, int power) {
        int totalIron = 0;
        for(int index = 1; index <=number; index++){
            int weight = getWeight(index);
            if(isOverLimit(weight, limit)) {
                totalIron += power;
                continue;
            }
            totalIron += weight;
        }
        return totalIron;
    }

    private int getWeight(int index) {
        int weight = 0;
        for (int count = 1; count <= Math.sqrt(index); count++) {
            weight += addWeightIfDivision(count, index);
        }
        if(index % Math.sqrt(index) == 0) return weight * 2 -1;
        return weight*2;
    }

    private int addWeightIfDivision(int count, int index){
        if(index % count == 0) return 1;
        return 0;
    }

    private boolean isOverLimit(int weight, int limit){
        return weight > limit;
    }
}