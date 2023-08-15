function solution(numbers, n) {
  let result = 0;
  for (let index = 0; index < numbers.length; index++) {
    result += numbers[index];
    if (result > n) {
      return result;
    }
  }
  return result;
}
