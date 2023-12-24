const arr = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map((v) => v.trim());

const calculateScore = (arr) => {
  const count = Number(arr[0]);
  const deleteCount = Math.round(count * 0.15);
  const start = 1 + deleteCount;
  const end = arr.length - deleteCount;
  return arr
    .slice(start, end)
    .reduce((total, amount) => total + Number(amount));
};

console.log(calculateScore(arr));
