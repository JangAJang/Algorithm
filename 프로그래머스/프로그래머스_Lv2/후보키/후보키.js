let count = 0;
function solution(relation) {
  let combinations = [];
  for (let index = 0; index < relation[0].length; index++) {
    combinations.push(...combination(relation[0].length, index + 1));
  }

  countCandidateKeys(relation, combinations);
  return count;
}

function countCandidateKeys(relation, combinations) {
  for (let columns of combinations) {
    if (isColumnsCandidate(relation, columns)) {
      count++;
      return countCandidateKeys(
        relation,
        combinations.filter((each) => !isArraySubset(columns, each))
      );
    }
  }
}

function isColumnsCandidate(relation, columns) {
  const set = new Set();
  for (let index = 0; index < relation.length; index++) {
    const mappedKey = columns.map((each) => relation[index][each]).join(".");
    set.add(mappedKey);
  }
  return relation.length == set.size;
}

function isArraySubset(subset, superset) {
  return subset.every(function (element) {
    return superset.includes(element);
  });
}

function combination(n, m) {
  var result = [];

  function generateCombination(start, current) {
    if (current.length === m) {
      result.push(current.slice());
      return;
    }

    for (var i = start; i < n; i++) {
      current.push(i);
      generateCombination(i + 1, current);
      current.pop();
    }
  }
  generateCombination(0, []);
  return result;
}
