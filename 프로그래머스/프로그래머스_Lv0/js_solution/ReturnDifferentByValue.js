// 홀짝에 따라 다른 값 반환하기 

function solution(n) {
    let value = 0;
    
    if(n %2 != 0) {
        for(index = 1; index <= n; index +=2) {
            value += index;
        }
        return value;
    }
    for(index = 2; index <= n; index +=2) {
        value += index*index;
    }
    return value;
}