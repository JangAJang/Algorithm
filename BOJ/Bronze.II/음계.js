const map = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((v) => Number(v.trim()));
// const map = "1 2 3 4 5 6 7 8".split(" ").map((v) => Number(v.trim()));

const solution = (arr) => {
  const sorted = [...arr].sort((a, b) => a - b);
  const reverse = [...arr].sort((a, b) => b - a);
  console.log(sorted);
  console.log(reverse);
  if (JSON.stringify(arr) == JSON.stringify(sorted)) return "ascending";
  if (JSON.stringify(arr) == JSON.stringify(reverse)) return "descending";
  return "mixed";
};

console.log(solution(map));
