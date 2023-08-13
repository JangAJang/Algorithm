function solution(a, b) {
  if (a % 2 == 0 && b % 2 == 0) {
    return Math.abs(a - b);
  }

  if (a % 2 == 0 || b % 2 == 0) {
    return 2 * (a + b);
  }

  return a * a + b * b;
}
