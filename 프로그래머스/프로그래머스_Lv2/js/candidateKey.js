const solution = (relation) => {};

const isCandidateCombination = (relation, startIndex) => {
  for (let index = startIndex + 1; index < relation[0].length + 1; index++) {
    const combinations = relation.map((each) => each.slice(startIndex, index));
    const map = {};
  }
};
