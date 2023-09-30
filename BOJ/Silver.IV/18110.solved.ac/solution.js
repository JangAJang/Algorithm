const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", (line) => {
  input.push(line);
  if (input.length === Number(input[0]) + 1) {
    rl.close();
  }
});

rl.on("close", () => {
  calculateScore();
  process.exit();
});

const calculateScore = () => {
  const length = Number(input[0]);
  const start = Math.round(length * 0.15);
  const end = length - start;
  const values = input
    .slice(1)
    .map(Number)
    .sort((a, b) => a - b)
    .slice(start, end);
  const average =
    values.reduce((sum, current) => sum + current, 0) / values.length;
  console.log(Math.floor(average));
};
