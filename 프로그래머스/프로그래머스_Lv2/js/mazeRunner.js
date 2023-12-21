function solution(maps) {
  const visited = [];
  let start;
  for (let x = 0; x < maps.length; x++) {
    maps[x] = maps[x].split("");
    const temp = [];
    for (let y = 0; y < maps[x].length; y++) {
      if (maps[x][y] === "S") {
        start = [x, y];
        temp.push(true);
        continue;
      }
      temp.push(false);
    }
    visited.push(temp);
  }
}

function BFS(graph, start, visited) {
  const queue = new Queue();
  queue.push(start);
  visited[start[0]][start[1]] = true;

  while (queue.size()) {
    const v = queue.popleft();

    for (const node of graph[v]) {
      if (!visited[node]) {
        queue.push(node);
        visited[node] = true;
      }
    }
  }
}

class Queue {
  constructor() {
    this.store = {};
    this.front = 0;
    this.rear = 0;
  }

  size() {
    if (this.store[this.rear] === undefined) {
      return 0;
    } else {
      return this.rear - this.front + 1;
    }
  }

  push(value) {
    if (this.size() === 0) {
      this.store["0"] = value;
    } else {
      this.rear += 1;
      this.store[this.rear] = value;
    }
  }

  popleft() {
    let temp;
    if (this.front === this.rear) {
      temp = this.store[this.front];
      delete this.store[this.front];
      this.front = 0;
      this.rear = 0;
      return temp;
    } else {
      temp = this.store[this.front];
      delete this.store[this.front];
      this.front += 1;
      return temp;
    }
  }
}
