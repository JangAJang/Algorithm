// 글자 이어붙여 문자열 만들기 

function solution(my_string, index_list) {
    var answer = '';
    
    for(index = 0; index < index_list.length; index++) {
        answer += my_string[index_list[index]];
    }
    
    return answer;
}