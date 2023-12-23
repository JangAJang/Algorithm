// 15829
const [N, string] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map((v) => v.split(""));

let sum = 0n;

const alphabet = {
  a: 1n,
  b: 2n,
  c: 3n,
  d: 4n,
  e: 5n,
  f: 6n,
  g: 7n,
  h: 8n,
  i: 9n,
  j: 10n,
  k: 11n,
  l: 12n,
  m: 13n,
  n: 14n,
  o: 15n,
  p: 16n,
  q: 17n,
  r: 18n,
  s: 19n,
  t: 20n,
  u: 21n,
  v: 22n,
  w: 23n,
  x: 24n,
  y: 25n,
  z: 26n,
};

string.forEach((el, idx) => {
  idx = BigInt(idx);
  sum += alphabet[el] * 31n ** idx;
});

console.log(String(sum % 1234567891n));
