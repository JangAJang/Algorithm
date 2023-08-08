function solution(arr) {
  let answer = [];
  arr.forEach((each) =>
    Array(each)
      .fill(0)
      .forEach((i) => answer.push(each))
  );
  return answer;
}
