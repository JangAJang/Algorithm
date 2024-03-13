let isNotAvailable;

const countMaxLevels = (levels, k) => {
  let remainingLevels = k;
  let count = 0;
  for (let index = 0; index < levels.length; index++) {
    remainingLevels -= levels[index];
    if (remainingLevels < 0) return count;
    count++;
  }
  return levels.length;
};

const checkUnavailable = (levels, maxCount, k, start) => {
  const stack = [];
  stack.push({ index: start, maxCount, k });

  while (stack.length > 0) {
    const { index, maxCount, k } = stack.pop();
    if (maxCount === 0) continue;
    if (index >= levels.length) continue;
    if (k <= 0) continue;

    for (let i = index; i < levels.length - maxCount + 1; i++) {
      if (levels[i] > k) continue;
      isNotAvailable[i] = false;
      stack.push({ index: i + 1, maxCount: maxCount - 1, k: k - levels[i] });
    }
  }
};

const solution = (levels, k) => {
  levels.sort((a, b) => b - a);
  const max = levels.shift();
  const others = levels.map((each) => max - each);
  const maxCount = countMaxLevels(others, k);
  if (maxCount === others.length) return 0;
  isNotAvailable = new Array(others.length).fill(true);
  checkUnavailable(others, maxCount, k, 0);
  return isNotAvailable.filter((each) => each).length;
};

console.log(solution([7, 1, 2, 4, 3], 8));
console.log(solution([100, 99, 1, 1], 99));
