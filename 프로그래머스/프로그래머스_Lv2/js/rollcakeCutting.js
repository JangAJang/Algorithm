function solution(topping) {
  let answer = 0;
  const topping1 = {},
    topping2 = {};
  let topping1Count = 0,
    topping2Count = 0;
  topping.forEach((element) => {
    if (topping2[element] === undefined) {
      topping2[element] = 1;
      topping2Count++;
    } else {
      topping2[element]++;
    }
  });
  topping.forEach((element) => {
    if (topping2[element] - 1 === 0) {
      topping2Count--;
      delete topping2[element];
    } else {
      topping2[element]--;
    }

    if (topping1[element] === undefined) {
      topping1Count++;
      topping1[element] = 1;
    } else {
      topping1[element]++;
    }

    answer += topping1Count === topping2Count;
  });

  return answer;
}
