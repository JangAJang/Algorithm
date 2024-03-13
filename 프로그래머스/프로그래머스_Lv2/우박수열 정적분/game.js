class Character {
  x;
  y;

  constructor(x, y) {
    this.x = x;
    this.y = y;
  }

  jump() {
    return new Character(this.x + 1, this.y + 1);
  }

  drop() {
    return new Character(this.x + 1, this.y - 2);
  }

  getPosition() {
    return [this.x, this.y];
  }

  isClear(x, y) {
    return this.x === x && this.y < y && this.y > 0;
  }

  isOut(y) {
    return this.y >= y || this.y <= 0;
  }
}

class Walls {
  holes;

  constructor(walls) {
    this.holes = [];
    for (let wall of walls) {
      this.holes.push(new Hole(wall));
    }
  }

  isOnWall(x, y) {
    for (let hole of this.holes) {
      if (hole.xEquals(x) && hole.isYOnWall(y)) return true;
    }
    return false;
  }
}

class Hole {
  x;
  yStart;
  yEnd;

  constructor([x, yStart, yEnd]) {
    this.x = x;
    this.yStart = yStart;
    this.yEnd = yEnd;
  }

  xEquals(x) {
    return this.x === x;
  }

  isYOnWall(y) {
    return !(this.yStart < y && y < this.yEnd);
  }
}

const solution = (w, h, walls) => {
  const structWalls = new Walls(walls);
  const bird = new Character(0, h / 2);
  const stack = [];
  let count = 0;
  stack.push(bird);
  while (stack.length !== 0) {
    const current = stack.pop();
    if (current.isOut()) continue;
    if (structWalls.isOnWall(current.x, current.y)) continue;
    if (current.isClear(w, h)) {
      count++;
      continue;
    }
    const jumped = current.jump();
    const dropped = current.drop();
    if (!jumped.isOut(h) && !structWalls.isOnWall(jumped.x, jumped.y))
      stack.push(jumped);
    if (!dropped.isOut(h) && !structWalls.isOnWall(dropped.x, dropped.y))
      stack.push(dropped);
  }
  return count === 0 ? -1 : count % 10007;
};

console.log(
  solution(8, 6, [
    [2, 3, 6],
    [4, 1, 5],
    [7, 3, 5],
  ])
); // 기댓값 4
console.log(
  solution(7, 4, [
    [1, 2, 4],
    [2, 0, 3],
    [5, 0, 2],
  ])
); // 기댓값 1
console.log(
  solution(8, 6, [
    [2, 1, 3],
    [5, 0, 2],
  ])
); // 기댓값 -1
console.log(
  solution(21, 12, [
    [3, 1, 3],
    [10, 3, 6],
  ])
); // 기댓값 2504
