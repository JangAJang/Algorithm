let sum;

function solution(k, ranges) {
  const arr = [];
  arr.push(k);
  while (k != 1) {
    k = parseValue(k);
    arr.push(k);
  }
  sum = Array.from({ length: arr.length }, () =>
    Array.from({ length: arr.length }, () => 0)
  );

  for (let index = 1; index < arr.length; index++) {
    sum[index - 1][index] = (arr[index - 1] + arr[index]) / 2;
  }
  return ranges.map((each) => {
    each[1] = arr.length + each[1] - 1;
    const min = Math.min(...each);
    const max = Math.max(...each);
    if (each[0] > each[1]) return -1;
    return calculatedAccumulated(min, max);
  });
}

function parseValue(k) {
  if (k % 2 === 0) {
    return k / 2;
  }
  return 3 * k + 1;
}

function calculatedAccumulated(start, end) {
  if (start === end) return 0;
  if (sum[start][end] !== 0) return sum[start][end];
  const middle = Math.floor((start + end) / 2);
  return (sum[start][end] =
    calculatedAccumulated(start, middle) + calculatedAccumulated(middle, end));
}
