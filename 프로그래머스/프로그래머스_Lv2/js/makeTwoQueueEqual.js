let sum1;
let sum2;
let q1Pointer;
let q2Pointer;

const calculateSum = (q, half) =>
  sum1 > half
    ? sum1 - q[q1Pointer++ % q.length]
    : sum1 + q[q2Pointer++ % q.length];

const solution = (queue1, queue2) => {
  sum1 = queue1.reduce((prev, cur) => prev + cur, 0);
  sum2 = queue2.reduce((prev, cur) => prev + cur, 0);
  const half = (sum1 + sum2) / 2;
  const q = [...queue1, ...queue2];
  q1Pointer = 0;
  q2Pointer = queue1.length;

  for (let cnt = 0; cnt < queue1.length * 3; cnt++) {
    if (sum1 === half) {
      return cnt;
    }
    sum1 = calculateSum(q, half);
  }

  return -1;
};
