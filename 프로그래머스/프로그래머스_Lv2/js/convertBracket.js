let opened = 0;
let closed = 0;
let answer = "";

function solution(p) {
  if (!p) return "";
  for (let i = 0; i < p.length; i++) {
    countOpenOrClose(p[i]);
    if (opened === closed) {
      return resolveAnswer(p);
    }
  }
}

function resolveAnswer(p) {
  if (check(p.slice(0, i + 1))) {
    answer = p.slice(0, i + 1) + solution(p.slice(i + 1));
    return answer;
  }
  createAnswer(p, i);
  coverAllBrackets(p);
  return answer;
}

function createAnswer(p, i) {
  answer = "(" + solution(p.slice(i + 1)) + ")";
}

function coverAllBrackets(p) {
  for (let j = 1; j < i; j++) {
    coverAnswer(p[j]);
  }
}

function coverAnswer(bracket) {
  if (isOpenBracket(bracket)) {
    answer = answer + ")";
    return;
  }

  answer = answer + "(";
}

function countOpenOrClose(bracket) {
  if (bracket === "(") {
    opened++;
    return;
  }

  closed++;
}

function check(p) {
  const stack = [];
  for (let i = 0; i < p.length; i++) {
    if (isOpenBracket(p[i])) {
      stack.push("(");
      continue;
    }

    if (stack.length === 0) return false;
    stack.pop();
  }
  return true;
}

const isOpenBracket = (bracket) => bracket === "(";
