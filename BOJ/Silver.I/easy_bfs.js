// 14940. 쉬운 최단거리

const xNext = [-1, 0, 1, 0];
const yNext = [0, -1, 0, 1];

const solution = (size, map, start) => {
  const visited = new Array(size[0]).fill(new Array(size[1]).fill(false));
  const result = new Array(size[0]).fill(
    new Array(size[1]).fill(Number.MAX_SAFE_INTEGER)
  );
  result[start[0][start[1]]] = 0;
  const queue = [];
  queue.push(start);
  while (queue.length !== 0) {
    const current = queue.shift();
    if (visited[current[0]][current[1]]) continue;
    for (let index = 0; index < 4; index++) {
      const nextX = xNext[index] + current[0];
      const nextY = yNext[index] + current[1];
      if (nextX < 0 || nextX >= size[0] || nextY < 0 || nextY >= size[1])
        continue;
      if (map[nextX][nextY] === "0") continue;
      result[nextX][nextY] = Math.min(
        result[current[0]][current[1]] + 1,
        result[nextX][nextY]
      );
      console.log(result[current[0]][current[1]] + 1, current);
      queue.push([nextX, nextY]);
    }
    visited[current[0]][current[1]] = true;
  }
  return result
    .map((each) =>
      each
        .map((value) => {
          if (value === Number.MAX_SAFE_INTEGER) return 0;
          return value;
        })
        .join(" ")
    )
    .join("\n");
};

const values = `15 15
2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1`.split("\n");
//require("fs").readFileSync("/dev/stdin").toString().split("\n");
const size = values.shift().split(" ").map(Number);
const map = values.map((each) => each.split(" "));
const start = [];
for (let x = 0; x < size[0]; x++) {
  for (let y = 0; y < size[1]; y++) {
    if (map[x][y] === "2") {
      start.push(x);
      start.push(y);
    }
  }
}
const result = solution(size, map, start);
console.log(result);
