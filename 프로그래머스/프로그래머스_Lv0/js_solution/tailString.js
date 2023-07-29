function solution(str_list, ex) {
  return str_list.filter((each) => !each.includes(ex)).join("");
}
