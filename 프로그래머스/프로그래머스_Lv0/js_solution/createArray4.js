const solution = (arr) => {
  const stk = [];
  let i = 0;
  while (i < arr.length) {
    if (stk.length === 0) {
      stk.push(arr[i]);
      i++;
      continue;
    }

    if (stk[stk.length - 1] < arr[i]) {
      stk.push(arr[i]);
      i++;
      continue;
    }

    stk.pop();
  }

  return stk;
};
