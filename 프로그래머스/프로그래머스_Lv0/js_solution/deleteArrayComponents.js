const solution = (arr, delete_list) =>
  arr.filter((each) => !delete_list.includes(each));
