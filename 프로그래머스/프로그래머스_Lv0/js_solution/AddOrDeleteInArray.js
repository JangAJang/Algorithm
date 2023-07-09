// 빈 배열에 추가, 삭제하기

function solution(arr, flag) {
    var answer = [];
    
    for(index = 0; index < flag.length; index++) {
        if(flag[index]) {
            for(count = 0; count < arr[index]*2; count++) {
                answer.push(arr[index]);
            }
            continue;
        }
        
        for(count = 0; count < arr[index]; count++) {
            answer.pop();
        }
    }
    
    return answer;
}