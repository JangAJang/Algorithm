// 미로 탈출

const X_DIRECT = [-1, 0, 1, 0];
const Y_DIRECT = [0, -1, 0, 1];

const map = [];
let visited = [];
let total = [];
const start = [];
const lever = [];
const end = [];

const createMap = (maps) => {
  for (let x = 0; x < maps.length; x++) {
    const row = maps[x].split("");
    map.push(row);
    for (let y = 0; y < row.length; y++) {
      if (row[y] === "S") {
        start.push(x);
        start.push(y);
        continue;
      }
      if (row[y] === "E") {
        end.push(x);
        end.push(y);
        continue;
      }
      if (row[y] === "L") {
        lever.push(x);
        lever.push(y);
        continue;
      }
    }
  }
};

const createVisited = () => {
  visited = map.map((each) => new Array(each.length).fill(false));
};

const createResult = () => {
  total = map.map((each) =>
    new Array(each.length).fill(Number.MAX_SAFE_INTEGER)
  );
};

const bfs = (start) => {
  const queue = [];
  queue.push(start);
  total[start[0]][start[1]] = 0;
  while (queue.length != 0) {
    const [x, y] = queue.shift();
    if (visited[x][y]) continue;
    visited[x][y] = true;
    for (let index = 0; index < 4; index++) {
      const nextX = x + X_DIRECT[index];
      const nextY = y + Y_DIRECT[index];
      if (
        nextX < 0 ||
        nextX >= map.length ||
        nextY < 0 ||
        nextY >= map[0].length
      )
        continue;
      if (map[nextX][nextY] === "X") continue;
      total[nextX][nextY] = Math.min(total[nextX][nextY], total[x][y] + 1);
      queue.push([nextX, nextY]);
    }
  }
};

const solution = (maps) => {
  createMap(maps);
  createVisited();
  createResult();
  bfs(start);
  const toLever = total[lever[0]][lever[1]];
  createVisited();
  createResult();
  bfs(lever);
  const toEnd = total[end[0]][end[1]];
  return toLever >= Number.MAX_SAFE_INTEGER || toEnd >= Number.MAX_SAFE_INTEGER
    ? -1
    : toLever + toEnd;
};
