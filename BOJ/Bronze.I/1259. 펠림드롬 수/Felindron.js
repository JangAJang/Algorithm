// Bronze.1 1259 펠린드롬 수 

const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on("line", (line) => {
    if(line == '0'){
        process.exit();
    }
    if(isFelindrom(line)){
        console.log("yes");
        return;
    }
    console.log("no");
});
rl.on('close', () => {
        process.exit();
});

function isFelindrom(str) {
    var left = 0;
    var right = str.length-1;
    while(left <= right) {
        if(str[left] != str[right])
        return false;
        left++;
        right--;
    }
    return true;
}