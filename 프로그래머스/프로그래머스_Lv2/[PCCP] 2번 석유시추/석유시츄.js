let totalCount;
const xMove = [-1, 1, 0, 0];
const yMove = [0, 0, -1, 1];

function solution(land) {
  totalCount = new Array(land[0].length).fill(0);
  for (let x = 0; x < land.length; x++) {
    for (let y = 0; y < land[0].length; y++) {
      if (land[x][y] == 0) continue;
      const [total, yAreas] = calculateAccumulated(land, x, y);
      for (let yArea of yAreas) {
        totalCount[yArea] += total;
      }
    }
  }

  return Math.max(...totalCount);
}

function calculateAccumulated(land, x, y) {
  const stack = [];
  const visited = Array.from({ length: land.length }, () =>
    Array(land[0].length).fill(false)
  );
  stack.push([x, y]);
  const yAreas = new Set();
  yAreas.add(y);
  let total = 0;
  while (stack.length !== 0) {
    const [sourceX, sourceY] = stack.pop();
    if (visited[sourceX][sourceY]) continue;
    visited[sourceX][sourceY] = true;
    land[sourceX][sourceY] = 0;
    total++;
    for (let index = 0; index < 4; index++) {
      const nextX = sourceX + xMove[index];
      const nextY = sourceY + yMove[index];
      if (
        nextX < 0 ||
        nextX >= land.length ||
        nextY < 0 ||
        nextY >= land[0].length
      )
        continue;
      if (visited[nextX][nextY]) continue;
      if (land[nextX][nextY] == 0) continue;
      stack.push([nextX, nextY]);
      yAreas.add(nextY);
    }
  }
  return [total, Array.from(yAreas)];
}
