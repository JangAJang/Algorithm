const solution = (jobs) => {
  const worksByWeight = [...jobs].sort((a, b) => a[1] - b[1]);
  const worksByStart = [...jobs].sort((a, b) => a[0] - b[0]);
  let time = 0;
  let answer = 0;
  while (worksByStart.length !== 0 && worksByWeight.length !== 0) {
    while (worksByWeight.length !== 0 && worksByStart[0][0] <= time) {
      if (worksByWeight.length === 0) {
        time = worksByStart[0][0];
        continue;
      }

      const j = worksByWeight.shift();
      answer += time + j[1] - j[0];
      time += j[1];
    }
  }
  return answer / jobs.length;
};
