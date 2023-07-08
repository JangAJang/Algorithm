// 9로 나눈 나머지 

function solution(number) {
    var value = 0;
    
    for(index = 0; index < number.length; index++) {
        value += Number(number[index]);
    }
    
    return value % 9;
}