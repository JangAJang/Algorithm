function solution(names) {
  let result = [];
  for (let index = 0; index < names.length; index += 5) {
    result.push(names[index]);
  }
  return result;
}
