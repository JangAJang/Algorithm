let accumulator;

const addSkill = ([type, r1, c1, r2, c2, degree]) => {
  for (let x = r1; x <= r2; x++) {
    for (let y = c1; y <= c2; y++) {
      accumulator[x][y] += degree;
    }
  }
};

function solution(board, skill) {
  accumulator = Array.from({ length: board.length }, () =>
    Array.from({ length: board[0].length }, () => 0)
  );

  for (let index = 0; index < skill.length; index++) {
    const type = skill[index][0] === 1 ? -1 : 1;
    skill[index][skill[index].length - 1] *= type;
    addSkill(skill[index]);
  }

  let count = 0;

  for (let x = 0; x < board.length; x++) {
    for (let y = 0; y < board[0].length; y++) {
      board[x][y] += accumulator[x][y];
      count += board[x][y] > 0 ? 1 : 0;
    }
  }
  return count;
}
