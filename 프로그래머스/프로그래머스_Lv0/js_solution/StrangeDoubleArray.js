// 특이한 이차원 배열 1

function solution(n) {
    var answer = [];
    for( x = 0; x < n; x++ ) {
        var temp = [];
        for( y = 0; y < n; y++ ) {
            if( x == y) {
                temp.push(1);
                continue;
            }
            temp.push(0);
        }
        answer.push(temp);
    }
    
    return answer;
}