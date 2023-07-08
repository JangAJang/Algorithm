// 전국 대학 선발 고사

function solution(rank, attendance) {
    var result = 0;
    var currentRank = 1;
    var score = 10000;
    
    for(index = 0; index < 3; index++) {
        var tmp = rank.indexOf(currentRank);
        
        if( !attendance.at(tmp) ) {
            currentRank++;
            index--;
            continue;
        }
        
        result += score * tmp;
        currentRank++;
        score /= 100;
    }
    
    return result;
}