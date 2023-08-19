function solution(my_string) {
  return Array(my_string.length)
    .fill()
    .map((v, i) => i)
    .map((each) => my_string.slice(each))
    .sort();
}
