function solution(numbers) {
  return numbers.map(findLeastAnswer);
}

const findLeastAnswer = (number) => {
  let value = number + 1;
  const binaryValue = number.toString(2);
  while (true) {
    const padded = padBinaryStrings(binaryValue, value.toString(2));
    if (differMoreThanTwo(padded)) return value;
    value++;
  }
};

const differMoreThanTwo = (binarys) => {
  let count = 0;
  for (let index = 0; index < binarys[0].length; index++) {
    if (binarys[0][index] != binarys[1][index]) count++;
    if (count > 2) return false;
  }
  return true;
};

const padBinaryStrings = (str1, str2) => {
  // 두 문자열의 길이를 비교하여 더 긴 길이를 구합니다.
  const maxLength = Math.max(str1.length, str2.length);

  // 각 문자열의 길이를 최대 길이에 맞게 0으로 패딩합니다.
  const paddedStr1 = str1.padStart(maxLength, "0");
  const paddedStr2 = str2.padStart(maxLength, "0");

  // 패딩된 두 문자열을 반환합니다.
  return [paddedStr1, paddedStr2];
};
