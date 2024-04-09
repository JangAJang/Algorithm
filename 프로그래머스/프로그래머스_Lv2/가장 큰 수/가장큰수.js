const solution = (numbers) => {
    numbers.sort((a, b) => -Number(String(a) + String(b)) + Number(String(b) + String(a)));
    if(numbers[0] == 0) return "0";
    return numbers.map(String).join("");
}

