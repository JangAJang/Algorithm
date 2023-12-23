// 15829
const [N, string] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((v) => v.split(""));

let sum = 0n;

const alphabet = (char) => {
  {
    if (!/^[a-zA-Z]$/.test(char)) {
      throw new Error(
        "Invalid input. Please provide a single alphabet character."
      );
    }

    // 알파벳을 소문자로 변환하여 ASCII 코드로 매핑
    const asciiCode = char.toLowerCase().charCodeAt(0);

    // 'a'의 ASCII 코드 값은 97이므로, 이를 기준으로 변환
    const result = BigInt(asciiCode - "a".charCodeAt(0) + 1);

    return result;
  }
};

string.forEach((el, idx) => {
  idx = BigInt(idx);
  sum += alphabet(el) * 31n ** idx;
});

console.log(String(sum % 1234567891n));
