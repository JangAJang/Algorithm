const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];

    let arr = [];
    for(index = 0; index < str.length; index++) {
        if(str[index] == str[index].toUpperCase()) {
            arr.push(str[index].toLowerCase());
            continue;
        }

        arr.push(str[index].toUpperCase());
    }

    console.log(arr.join(""));
});