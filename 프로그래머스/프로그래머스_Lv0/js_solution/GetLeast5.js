// 뒤에서 5등까지 

function solution(num_list) {
    num_list.sort(function(a, b) {
        if( a > b)
            return 1;
        if( a == b) 
            return 0;
        return -1;
    })
    
    var answer = [];
    
    for(index = 0; index < 5; index++) {
        answer.push(num_list[index]);
    }
    
    return answer;
}