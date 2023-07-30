function solution(arr) {
  for (let x = 0; x < arr.length; x++) {
    for (let y = 0; y < arr[x].length; y++) {
      if (arr[x][y] != arr[y][x]) return 0;
    }
  }
  return 1;
}
