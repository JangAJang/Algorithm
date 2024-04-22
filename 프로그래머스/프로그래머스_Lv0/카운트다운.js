function solution(start, end_num) {
  let count = -1;
  return Array(start - end_num + 1)
    .fill(start)
    .map((each) => {
      count++;
      return each - count;
    });
}
