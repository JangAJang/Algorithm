// 그림 확대하기 

function solution(picture, k) {
    var answer = [];
    
    for(index = 0; index < picture.length; index++) {
        var temp = "";
        
        for(char = 0; char < picture[index].length; char++) {
            for(repeat = 0; repeat < k; repeat++) {
                temp += picture[index][char];
            }
        }
        
        for(repeat = 0; repeat < k; repeat++) {
            answer.push(temp);   
        }
    }
    
    return answer;
}