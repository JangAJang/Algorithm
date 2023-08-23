function solution(arr, queries) {
  queries.forEach((query) => {
    arr = arr.map((value, index) => {
      if (index >= query[0] && index <= query[1]) {
        return value + 1;
      }
      return value;
    });
  });
  return arr;
}
