const xNext = [-1, 0, 1, 0];
const yNext = [0, -1, 0, 1];
const MAX = Number.MAX_SAFE_INTEGER;

const solution = (board) => {
  const map = [];
  const start = [];
  const end = [];
  for (let x = 0; x < board.length; x++) {
    const arr = board[x].split("");
    for (let y = 0; y < board[x].length; y++) {
      if (arr[y] === "G") {
        end.push(x);
        end.push(y);
        continue;
      }

      if (arr[y] === "R") {
        start.push(x);
        start.push(y);
      }
    }
    map.push(arr);
  }
  const visited = new Array(map.length).fill(
    new Array(map[0].length).fill(false)
  );
  let total = new Array(map.length).fill(new Array(map[0].length).fill(MAX));
  const queue = [];
  queue.push(start);
  total[start[0]][start[1]] = 0;
  while (queue.length != 0) {
    const current = queue.shift();
    if (visited[current[0]][current[1]]) continue;
    console.log(current);
    visited[current[0]][current[1]] = true;
    for (let index = 0; index < 4; index++) {
      const x = xNext[index] + start[0];
      const y = yNext[index] + start[1];
      if (x < 0 || x >= visited.length || y < 0 || y >= visited[0].length)
        continue;
      if (visited[x][y]) continue;
      total[x][y] = Math.min(total[x][y], total[current[0]][current[1]] + 1);
      queue.push([x, y]);
    }
  }
  return total[end[0]][end[1]];
};
