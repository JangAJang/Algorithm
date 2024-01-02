// 21736. 헌내기는 친구가 필요해

const xNext = [-1, 0, 1, 0];
const yNext = [0, -1, 0, 1];
let max = 0;

const map = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .split("\n")
  .map((v) => v.trim());
map.shift();

const start = [];

for (let x = 0; x < map.length; x++) {
  map[x] = map[x].split("");
  for (let y = 0; y < map[x].length; y++) {
    if (map[x][y] === "I") {
      start.push(x);
      start.push(y);
    }
  }
}

const findMeetableFriends = (map, start) => {
  const visited = new Array(map.length).fill(
    new Array(map[0].length).fill(false)
  );
  const queue = [];
  queue.push(new Position(start[0], start[1], 0));
  while (queue.length != 0) {
    const current = queue.shift();
    if (visited[current.x][current.y]) continue;
    visited[current.x][current.y] = true;
    for (let index = 0; index < 4; index++) {
      const x = xNext[index] + current.x;
      const y = yNext[index] + current.y;
      if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) continue;
      if (map[x][y] === "X") continue;
      const count = (map[x][y] === "P" ? 1 : 0) + current.count;
      queue.push(new Position(x, y, count));
      max = Math.max(max, count);
    }
  }
};

class Position {
  x;
  y;
  count;

  constructor(x, y, count) {
    this.x = x;
    this.y = y;
    this.count = count;
  }
}

findMeetableFriends(map, start);
console.log(max);
