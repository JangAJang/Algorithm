import java.util.ArrayList;
import java.util.List;

class Solution {

    private final List<Integer> people = new ArrayList<>();

    public int solution(int number, int limit, int power) {
        calculateWeapons(number);
        return sumAllIngredients(limit, power);
    }

    private int sumAllIngredients(int limit, int power){
        int result = 0;
        for(int index = 0; index < people.size(); index++){
            result += getWeightForPerson(index, limit, power);
        }
        return result;
    }

    private int getWeightForPerson(int index, int limit, int power){
        if(isOverWeight(index, limit)) return power;
        return people.get(index);
    }

    private boolean isOverWeight(int index, int limit){
        return people.get(index) > limit;
    }

    private void calculateWeapons(int number){
        for(int index = 1; index <= number; index++){
            people.add(measureWeapon(index));
        }
    }

    private int measureWeapon(int weapon){
        int count = 0;
        for(int index = 1; index <= weapon; index++){
            if(weapon % index == 0) count++;
        }
        return count;
    }
}