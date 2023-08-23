function solution(strArr) {
  const result = {};
  strArr.forEach((each) => {
    result[String(each.length)] =
      result[String(each.length)] === undefined
        ? 1
        : result[String(each.length)] + 1;
  });
  return Math.max(...Object.keys(result).map((each) => result[each]));
}
