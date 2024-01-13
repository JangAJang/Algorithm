function solution(n, s) {
  const array = new Array(n).fill(Math.floor(s / n));
  if (array.reduce((acc, current) => acc + current, 0) === 0) return [-1];
  let left = s % n;
  let index = n - 1;
  while (left > 0) {
    array[index]++;
    index = (index - 1 + n) % n;
    left--;
  }
  return array;
}
