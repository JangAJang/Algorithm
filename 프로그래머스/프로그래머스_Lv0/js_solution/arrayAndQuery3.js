function solution(arr, queries) {
  for (let index = 0; index < queries.length; index++) {
    let tmp = arr[queries[index][0]];
    arr[queries[index][0]] = arr[queries[index][1]];
    arr[queries[index][1]] = tmp;
  }
  return arr;
}
