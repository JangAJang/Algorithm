const fs = require("fs");
// const input = fs.readFileSync("/dev/stdin", "utf-8").trim().split("\n");

const input = `11001110
10000101
01111110
01101111
4
2 -1
2 -1
2 1
2 1`.split("\n");

const CYCLE_TYPE = [
  [1, -1, 1, -1],
  [-1, 1, -1, 1],
];

let sawteeth = [];

const findCyclingTooth = (chosen) => {
  const arr = new Array(sawteeth.length).fill(false);
  arr[chosen] = true;
  findForward(arr, chosen);
  findBackward(arr, chosen);
  return arr;
};

const findForward = (arr, chosen) => {
  for (let index = chosen - 1; index >= 0; index--) {
    if (sawteeth[index + 1][6] !== sawteeth[index][2]) {
      arr[index] = true;
    }
    return;
  }
};

const findBackward = (arr, chosen) => {
  for (let index = chosen + 1; index < sawteeth.length; index++) {
    if (sawteeth[index][6] !== sawteeth[index - 1][2]) {
      arr[index] = true;
    }
    return;
  }
};

const createCycleCommand = (chosen, cycle) => {
  const cyclingTooth = findCyclingTooth(chosen);
  const direction = CYCLE_TYPE[CYCLE_TYPE[0][chosen] === cycle ? 0 : 1];
  const command = [];
  for (let index = 0; index < 4; index++) {
    if (cyclingTooth[index]) {
      command.push(direction[index]);
      continue;
    }
    command.push(0);
  }
  return command;
};

const activateCommand = (command) => {
  for (let index = 0; index < 4; index++) {
    if (command[index] === 0) continue;
    if (command[index] === 1) {
      cycleClockwise(index);
      continue;
    }
    cycleCounterClockwise(index);
  }
};

const cycleClockwise = (index) => {
  sawteeth[index].unshift(sawteeth[index].pop());
};

const cycleCounterClockwise = (index) => {
  sawteeth[index].push(sawteeth[index].shift());
};

for (let index = 0; index < 4; index++) {
  sawteeth.push(input[index].split("").map((each) => Number(each)));
}

for (let index = 5; index < input.length; index++) {
  const [chosen, direction] = input[index]
    .split(" ")
    .map((each) => Number(each));
  activateCommand(createCycleCommand(chosen - 1, direction));
}

let answer = 0;

for (let index = 0; index < 4; index++) {
  answer += Math.pow(2, index) * sawteeth[index][0];
}

console.log(answer);
console.log(sawteeth.map((each) => each[0]));
