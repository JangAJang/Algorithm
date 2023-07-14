// 무작위로 K개의 수 뽑기

function solution(arr, k) {
  let answer = [];
  for (let index = 0; index < arr.length; index++) {
    if (!answer.includes(arr[index])) {
      answer.push(arr[index]);
    }

    if (answer.length == k) {
      return answer;
    }
  }

  for (let count = answer.length; count < k; count++) {
    answer.push(-1);
  }

  return answer;
}
