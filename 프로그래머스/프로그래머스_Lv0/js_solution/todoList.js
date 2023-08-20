function solution(todo_list, finished) {
  const result = [];
  for (let index = 0; index < todo_list.length; index++) {
    if (!finished[index]) {
      result.push(todo_list[index]);
    }
  }

  return result;
}
