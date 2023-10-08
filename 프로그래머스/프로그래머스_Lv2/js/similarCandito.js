// 유사 칸토어 배열

const solution = (n, l, r) => {
  let answer = 0;

  for (let i = l - 1; i < r; i++) {
    if (check(i)) {
      answer++;
    }
  }

  return answer;
};

const check = (l) => {
  if (l < 5 && l !== 2) {
    return true;
  }

  if ((l - 2) % 5 === 0) {
    return false;
  }

  return check(Math.floor(l / 5));
};
