function solution(my_string, m, c) {
  let result = "";
  for (let index = 0; index < my_string.length; index++) {
    if (index % m === c - 1) {
      result += my_string[index];
    }
  }

  return result;
}
