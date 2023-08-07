function solution(myString) {
  return myString
    .split("")
    .map((each) => (each < "l" ? "l" : each))
    .join("");
}
