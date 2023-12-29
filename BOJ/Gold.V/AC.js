const main = () => {
  const inputs = getInput();
  inputs.shift();
  const cases = [];
  while (inputs.length > 0) {
    const eachCase = {
      command: inputs.shift().trim(),
      count: inputs.shift(),
      array: inputs
        .shift()
        .trim()
        .replace("[", "")
        .replace("]", "")
        .split(",")
        .map(Number),
    };
    cases.push(eachCase);
  }
  solution(cases);
};

const solution = (cases) =>
  cases.forEach((eachCase) => {
    try {
      const result = checkCase(eachCase);
      console.log(result.length === 0 ? "error" : result);
    } catch (e) {
      console.log(e);
    }
  });

const checkCase = (eachCase) => {
  let array = eachCase.array;
  eachCase.command.split("").forEach((each) => {
    if (each === "R") {
      array = reverse(array);
      return;
    }

    array = deleteFront(array);
  });
  return array;
};

const reverse = (array) => array.reverse();

const deleteFront = (array) => {
  array.shift();
  return array;
};

const getInput = () =>
  require("fs").readFileSync("dev/stdin").toString().trim().split("\n");

main();
