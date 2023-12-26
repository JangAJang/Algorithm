// 해당 문제는 원래 nodejs로 지원하진 않습니다.

let array = new Array(20).fill(false);

const solution = (commands) => {
  commands.forEach(parseCommand);
};

const parseCommand = (command) => {
  const [word, value] = command.split(" ");
  if (word === "add") {
    add(parseValueToIndex(value));
    return;
  }

  if (word === "remove") {
    remove(parseValueToIndex(value));
    return;
  }

  if (word === "check") {
    check(parseValueToIndex(value));
    return;
  }

  if (word === "toggle") {
    toggle(parseValueToIndex(value));
    return;
  }

  if (word === "all") {
    all();
    return;
  }

  empty();
};

const add = (index) => {
  array[index] = true;
};

const remove = (index) => {
  array[index] = false;
};

const check = (index) => {
  if (array[index]) {
    console.log(1);
    return;
  }

  console.log(0);
};

const toggle = (index) => {
  if (array[index]) {
    remove(index);
    return;
  }

  array[index] = true;
};

const all = () => {
  array = new Array(20).fill(true);
};

const empty = () => {
  array = new Array(20).fill(false);
};

const parseValueToIndex = (value) => Number(value) - 1;
