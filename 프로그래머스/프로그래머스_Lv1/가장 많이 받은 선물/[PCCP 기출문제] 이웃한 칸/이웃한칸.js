const array = [
  [-1, 0],
  [1, 0],
  [0, 1],
  [0, -1],
];

const solution = (board, h, w) => {
  let count = 0;

  for (each of array) {
    const newH = h + each[0];
    const newW = w + each[1];

    if (
      newH < 0 ||
      newH >= board.length() ||
      newW < 0 ||
      newW >= board[0].length
    )
      continue;
    if (board[newH][newW] === board[h][w]) count++;
  }

  return count;
};
