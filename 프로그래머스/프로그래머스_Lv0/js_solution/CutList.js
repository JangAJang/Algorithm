// 리스트 자르기

function solution(n, slicer, num_list) {
    var answer = [];
    
    if( n == 1) {
        return num_list.slice(0, slicer[1]+1);
    }
    
    if( n == 2) {
        return num_list.slice(slicer[0]);
    }
    
    if( n == 3) {
        return num_list.slice(slicer[0], slicer[1]+1);
    }
    
    for(index = slicer[0]; index <= slicer[1]; index += slicer[2]) {
        answer.push(num_list[index]);
    }
    
    return answer;
}