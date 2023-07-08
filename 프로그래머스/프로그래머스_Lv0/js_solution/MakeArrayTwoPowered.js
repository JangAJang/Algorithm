// 배열의 길이를 2의 거듭제곱으로 만들기

function solution(arr) {
    var length = 1;
    
    while(length < arr.length) {
        length *= 2;
    }
    
    var answer = [];
    
    for(index = 0; index < arr.length; index++) {
        answer.push(arr[index]);
    }
    
    for(index = arr.length; index < length; index++) {
        answer.push(0);
    }
    
    return answer;
}