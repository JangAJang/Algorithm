function solution(n) {
  const numArr = [];
  for (let i = 1; i <= n; i++) {
    numArr.push(new Array(i).fill(0));
  }
  let row = -1,
    col = 0;
  let curNum = 1;

  for (let i = n; i > 0; i -= 3) {
    for (let j = 0; j < i; j++) {
      numArr[++row][col] = curNum++;
    }
    for (let j = 0; j < i - 1; j++) {
      numArr[row][++col] = curNum++;
    }
    for (let j = 0; j < i - 2; j++) {
      numArr[--row][--col] = curNum++;
    }
  }
  return numArr.flat();
}
