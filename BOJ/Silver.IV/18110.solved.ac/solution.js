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
  const values = input.slice(1);
  console.log(values);
};
