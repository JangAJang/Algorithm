function solution(arr, idx) {
  return arr.slice(idx).indexOf(1) === -1
    ? -1
    : arr.slice(idx).indexOf(1) + idx;
}
