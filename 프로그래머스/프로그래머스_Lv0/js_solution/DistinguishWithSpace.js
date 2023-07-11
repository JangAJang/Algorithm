// 공백으로 구분하기 2

function solution(my_string) {
    var answer = my_string.trim();
    while(answer.includes("  ")) {
        answer = answer.replace("  ", " ");
    }
    return answer.split(" ");
}