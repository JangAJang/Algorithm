function solution(num_list, n) {
  const result = [];
  for (let index = 0; index < num_list.length; index++) {
    if (index % n === 0) {
      result.push(num_list[index]);
    }
  }

  return result;
}
