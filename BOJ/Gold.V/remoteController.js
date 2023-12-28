let closest;
let dist;
let min;
let cur;

const main = () => {
  const input = getInput();
  const N = +input[0].trim();
  const M = +input[1].trim();
  let broken = [];
  if (M !== 0)
    broken = input
      .slice(2)[0]
      .split(" ")
      .map((_) => Number(_.trim()));

  const nums = new Array(10).fill(true);
  broken.forEach((index) => (numbers[broken[index]] = false));
  return console.log(solution(N, nums));
};

const solution = (N, nums) => {
  if (N == 100) return 0;
  closest = 100;
  dist = Math.abs(N - 100);
  min = dist;
  countNumberButtonAndMoving();

  return min;
};

const countNumberButtonAndMoving = () => {
  for (let i = 0; i <= 999900; i++) {
    let check = true;
    checkBrokenNumbers(i.toString());
    if (check) pressNumbers();
  }
};

const checkBrokenNumbers = (cur) => {
  for (let j = 0; j < cur.length; j++) {
    if (!nums[cur[j]]) {
      check = false;
      break;
    }
  }
};

const pressNumbers = () => {
  cur = Number(cur);
  let newDist = Math.abs(N - cur);
  if (newDist < dist) {
    let temp = 0;
    temp += cur.toString().length;
    temp += Math.abs(N - cur);
    if (temp < min) {
      dist = Math.abs(N - cur);
      min = temp;
    }
  }
};

const getInput = () =>
  require("fs").readFileSync("dev/stdin").toString().trim().split("\n");

main();
