const solution = (arr) => {
  const sorted = [...arr].sorted((a, b) => a - b);
  const reverse = [...arr].sorted((a, b) => b - a);
  if (arr == sorted) return "ascending";
  if (arr == reverse) return "descending";
  return mixed;
};
