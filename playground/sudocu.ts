const fillMultiplicationTable = (table: Number[][]) => {
  const rows = table.length;
  const cols = table[0].length;
  const visited = new Array(rows)
    .fill(null)
    .map(() => new Array(cols).fill(false));

  const queue: Position[] = [];
  const start = new Position(0, 0, 1);
  queue.push(start);

  while (queue.length > 0) {
    const position = queue.shift();

    // 이미 방문한 경우 다음으로 넘어감
    if (!position || visited[position.row][position.col]) {
      continue;
    }

    // 현재 위치에 값을 채움
    table[position.row][position.col] = position.multiplier;

    // 아래와 오른쪽으로 이동하는 경우를 큐에 추가
    if (position.row + 1 < rows) {
      queue.push(
        new Position(position.row + 1, position.col, position.multiplier + 1)
      );
    }
    if (position.col + 1 < cols) {
      queue.push(
        new Position(position.row, position.col + 1, position.multiplier + 1)
      );
    }

    // 해당 열의 다음 행에 현재 multiplier 값을 넣음
    if (position.col === 0 && position.multiplier + 1 <= 9) {
      queue.push(
        new Position(position.row + 1, position.col, position.multiplier + 1)
      );
    }

    // 해당 행의 다음 열에 현재 multiplier 값을 넣음
    if (position.row === 0 && position.multiplier + 1 <= 9) {
      queue.push(
        new Position(position.row, position.col + 1, position.multiplier + 1)
      );
    }

    // 방문 처리
    visited[position.row][position.col] = true;
  }
};

class Position {
  row: number;
  col: number;
  multiplier: number;

  constructor(row: number, col: number, multiplier: number) {
    this.row = row;
    this.col = col;
    this.multiplier = multiplier;
  }
}
