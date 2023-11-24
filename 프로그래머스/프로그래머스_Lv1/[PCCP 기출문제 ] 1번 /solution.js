function solution(bandage, health, attacks) {
  let leftHealth = health;
  attacks.unshift([0, 0]);
  for (let index = 1; index < attacks.length; index++) {
    let timeGap = attacks[index][0] - attacks[index - 1][0] - 1;
    let newHealth = Math.min(
      leftHealth +
        timeGap * bandage[1] +
        Math.floor(timeGap >= bandage[0] ? 1 : 0) * bandage[2],
      health
    );
    newHealth -= attacks[index][1];
    if (leftHealth <= 0) {
      return -1;
    }
    leftHealth = newHealth;
  }

  return leftHealth <= 0 ? -1 : leftHealth;
}
