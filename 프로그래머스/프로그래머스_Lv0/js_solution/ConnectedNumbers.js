// 이어 붙인 수

function solution(num_list) {
    evenSum = '';
    oddSum = '';
    for( index = 0; index < num_list.length; index++) {
        if(num_list[index] % 2 == 0) {
            evenSum += num_list[index];
            continue;
        }
        
        oddSum += num_list[index];
    }
    
    return Number(evenSum) + Number(oddSum);
}