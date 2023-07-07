// n번째 원소부터

function solution(num_list, n) {
    var answer = [];
    for(index = n-1; index < num_list.length; index++) {
        answer.push(num_list[index]);
    }
    
    return answer;
}