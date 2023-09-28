function solution(code) {
  let mode = 0;
  const retCode = code
    .split("")
    .filter((value, idx) => {
      if (value === "1") {
        mode = mode === 0 ? 1 : 0;
        return false;
      }

      // mode === 1
      if (mode) {
        return idx % 2 === 1;
      }
      // mode === 0
      return idx % 2 === 0;
    })
    .join("");
  const answer = retCode.length !== 0 ? retCode : "EMPTY";
  return answer;
}
