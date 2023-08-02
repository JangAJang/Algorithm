function solution(myString, pat) {
  const including = myString
    .split("")
    .map((each) => {
      if (each === "A") return "B";
      return "A";
    })
    .join("")
    .includes(pat);
  if (including) return 1;
  return 0;
}
