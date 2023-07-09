// 문자열 정수의 합

function solution(num_str) {
    var result = 0;
    
    for( index = 0; index < num_str.length; index++ ) {
        result += Number(num_str[index]);
    }
    
    return result;
}