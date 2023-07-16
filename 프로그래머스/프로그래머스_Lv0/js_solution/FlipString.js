function solution(my_string, queries) {
  let answer = my_string;
  for (let index = 0; index < queries.length; index++) {
    let temp = "";
    for (let before = 0; before < queries[index][0]; before++) {
      temp += answer[before];
    }
    for (let end = queries[index][1]; end >= queries[index][0]; end--) {
      temp += answer[end];
    }
    for (let after = queries[index][1] + 1; after < answer.length; after++) {
      temp += answer[after];
    }
    answer = temp;
  }
  return answer;
}
