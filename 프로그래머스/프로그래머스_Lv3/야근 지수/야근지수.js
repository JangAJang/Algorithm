function solution(n, works) {
  works.sort((a, b) => {
    return b - a;
  });

  for (let index = 0; index < n; index++) {
    let work = works.shift();
    if (work === 0) return 0;

    works.unshift(work - 1);
    works.sort((a, b) => b - a);
  }
  return works
    .map((each) => each * each)
    .reduce((acc, current) => acc + current, 0);
}
