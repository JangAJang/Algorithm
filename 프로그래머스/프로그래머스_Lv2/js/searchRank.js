function solution(info, query) {
  const map = initializeTree();
  info.forEach((infoEach) => parse(map, infoEach));
  query.map(count);
  return answer;
}

function parse(map, infoEach) {
  const [lang, area, exp, soulFood, score] = infoEach.split(" ");
  console.log(JSON.stringify(map, null, 2));
  console.log([lang, area, exp, soulFood, score]);
  map[lang][area][exp][soulFood].push(score);
}

function count(queryEach) {
  const dataMap = queryEach.split(" ").filter((each) => each !== "and");
}

function initializeTree() {
  return {
    java: createAreaTree(),
    python: createAreaTree(),
    cpp: createAreaTree(),
  };
}

function createAreaTree() {
  return {
    backend: createExpTree(),
    frontent: createExpTree(),
  };
}

function createExpTree() {
  return {
    junior: createSoulFoodTree(),
    senior: createSoulFoodTree(),
  };
}

function createSoulFoodTree() {
  return {
    chicken: [],
    pizza: [],
  };
}

solution(
  [
    "java backend junior pizza 150",
    "python frontend senior chicken 210",
    "python frontend senior chicken 150",
    "cpp backend senior pizza 260",
    "java backend junior chicken 80",
    "python backend senior chicken 50",
  ],
  [
    "java and backend and junior and pizza 100",
    "python and frontend and senior and chicken 200",
    "cpp and - and senior and pizza 250",
    "- and backend and senior and - 150",
    "- and - and - and chicken 100",
    "- and - and - and - 150",
  ]
);
