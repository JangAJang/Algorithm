const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const height = [];
let b = 0;
let n = 0;
let m = 0;

rl.on("line", (line) => {
  if (n === 0 && m === 0 && b === 0) {
    [n, m, b] = line.split(" ").map(Number);
    return;
  }

  if (height.length < n) {
    height.push(line.split(" ").map(Number));
  }

  if (height.length === n) rl.close();
});

rl.on("close", () => {
  console.log(calculateBlocks(height, n, m, b).join(" "));
  process.exit();
});

const calculateBlocks = (heights, n, m, b) => {
  let minTime = Infinity;
  let minHeight = Infinity;
  for (let h = 0; h <= 256; h++) {
    let time = 0;
    let blocksAdded = 0;
    let blocksRemoved = 0;

    for (let i = 0; i < n; i++) {
      for (let j = 0; j < m; j++) {
        const diff = heights[i][j] - h;

        if (diff > 0) {
          time += diff * 2;
          blocksRemoved += diff;
        } else if (diff < 0) {
          time -= diff;
          blocksAdded -= diff;
        }
      }
    }
    if (blocksAdded <= b + blocksRemoved) {
      if (time <= minTime) {
        minTime = time;
        minHeight = h;
      }
    }
  }

  return [minTime, minHeight];
};
