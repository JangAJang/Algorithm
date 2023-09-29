// 15829

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];

rl.on("line", (line) => {
  input.push(line);
  if (input.length === 2) {
    rl.close();
  }
});

rl.on("close", () => {
  console.log(hashFunc());
  process.exit();
});

const hashFunc = () => {
  const alphabets = input[1];
  let result = 0;
  alphabets.split("").forEach((each, index) => {
    result +=
      Math.pow(31, index) * (each.charCodeAt(0) - "a".charCodeAt(0) + 1);
  });
  return result;
};
