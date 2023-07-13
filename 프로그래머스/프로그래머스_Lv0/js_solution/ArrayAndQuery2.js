function solution(arr, queries) {
  let answer = [];
  for (index = 0; index < queries.length; index++) {
    let result = 1000000;
    for (start = queries[index][0]; start <= queries[index][1]; start++) {
      if (arr[start] > queries[index][2]) {
        result = result > arr[start] ? arr[start] : result;
      }
    }
    answer.push(result == 1000000 ? -1 : result);
  }
  return answer;
}
