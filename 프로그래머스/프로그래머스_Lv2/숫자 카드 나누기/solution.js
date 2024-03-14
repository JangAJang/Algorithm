function dividing(arr, num) {
  for (let n of arr) {
    if (n % num == 0) continue;
    else return false;
  }

  return true;
}

function notDividing(arr, num) {
  for (let n of arr) {
    if (n % num != 0) continue;
    else return false;
  }

  return true;
}

function solution(arrayA, arrayB) {
  let answer = 0;
  const num = Math.max(arrayA[0], arrayB[0]);
  for (let i = 2; i <= num; i++) {
    if (
      (dividing(arrayA, i) && notDividing(arrayB, i)) ||
      (dividing(arrayB, i) && notDividing(arrayA, i))
    ) {
      answer = i;
    }
  }
  return answer;
}
