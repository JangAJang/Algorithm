const solution = (n, t, m, p) => {
  const max = (t - 1) * m + p;
  let str = "";
  let number = 0;
  while (str.length < max) {
    str += (number++).toString(n);
  }

  return str
    .split("")
    .filter((v, i) => i <= max && i % m === p - 1)
    .join("")
    .toUpperCase();
};
