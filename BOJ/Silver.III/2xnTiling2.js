// 11727. 2xn타일링 2

const arr = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map((v) => v.trim());

const array = [0, 1, 3];

const solution = (n) => {
  return f(n);
};

const f = (n) => {
  if (array[n]) return array[n];

  array[n] = ((f(n - 1) % 10007) + ((2 * f(n - 2)) % 10007)) % 10007;
  return array[n];
};

console.log(solution(Number(arr[0])));
