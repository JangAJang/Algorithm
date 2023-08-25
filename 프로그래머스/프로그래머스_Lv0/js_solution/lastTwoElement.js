function solution(num_list) {
  const last =
    num_list[num_list.length - 1] > num_list[num_list.length - 2]
      ? num_list[num_list.length - 1] - num_list[num_list.length - 2]
      : num_list[num_list.length - 1] * 2;
  num_list.push(last);
  return num_list;
}
