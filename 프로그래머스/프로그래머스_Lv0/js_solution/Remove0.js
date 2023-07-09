// 0 떼기

function solution(n_str) {
    var start = 0;
    
    while(n_str[start] == '0') {
        start++;
    }
    
    return n_str.substring(start);
}