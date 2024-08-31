let time:number[];
let size:number;

const solution = (n:number, times:number[]) => {
    time = times;
    size = time.length;
    let start = 0;
    let end = Number.MAX_VALUE / 100;
    while (start < end) {
        let mid = (start + end) / 2;
        let count = calculate(mid);
        if(n <= count) {
            end = mid;
            continue;
        }

        start = mid+1;
    }

    return start;
}

const calculate = (check:number) => {
    let sum = 0;
    for(let each of time) {
        sum += check / each;
    }

    return sum;
}