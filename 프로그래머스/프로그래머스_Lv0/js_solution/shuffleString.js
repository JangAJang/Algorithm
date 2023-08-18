function solution(str1, str2) {
  let result = "";
  for (let index = 0; index < str1.length; index++) {
    result += str1[index] + str2[index];
  }

  return result;
}
