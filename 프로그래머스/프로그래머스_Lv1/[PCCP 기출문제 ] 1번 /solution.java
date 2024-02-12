class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
    
    int cast_time = bandage[0]; 
    int healing_per_second = bandage[1]; 
    int additional_healing = bandage[2]; 
    
    int max_health = health; 
    
    int pre_attack_time = attacks[0][0];
    
    for(int i=0; i<attacks.length; i++){
        int attack_time = attacks[i][0];
        int damage = attacks[i][1];
        int time_between = attack_time - pre_attack_time - 1;
    if (time_between > 0){
    
        health += (time_between * healing_per_second);
        health += ((time_between / cast_time) * additional_healing);
    
            if (health > max_health){
                health = max_health;
            }
        }
        health -= damage;
        if (health <= 0) return -1;
        pre_attack_time = attack_time;
    }
    return health;
    }
}