function solution(arr, query) {
  for (let index = 0; index < query.length; index++) {
    if (index % 2 === 0) {
      arr = arr.slice(0, query[index] + 1);
      continue;
    }

    arr = arr.slice(query[index]);
  }

  return arr;
}
