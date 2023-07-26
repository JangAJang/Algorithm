function solution(code) {
  let isEvenIndex = true;
  let result = "";
  for (let index = 0; index < code.length; index++) {
    if (code[index] === "1") {
      isEvenIndex = !isEvenIndex;
      continue;
    }
    if (isEvenIndex && index % 2 == 0) {
      result += code[index];
      continue;
    }
    if (!isEvenIndex && index & (2 != 0)) {
      result += code[index];
      continue;
    }
  }
  return result;
}
