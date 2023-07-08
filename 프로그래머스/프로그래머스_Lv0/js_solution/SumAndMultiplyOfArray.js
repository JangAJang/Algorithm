// 원소들의 곱과 합

function solution(num_list) {
    powerSum = 0;
    mult = 1;
    for(index = 0; index < num_list.length; index++) {
        powerSum += num_list[index];
        mult *= num_list[index];
    }
    powerSum **= 2;
    
    return powerSum > mult ? 1 : 0;
}