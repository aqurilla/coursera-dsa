/*
You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed.
*/
/**
 * @param {number[][]} pairs
 * @return {number}
 */
const findLongestChain = function (pairs) {
  let curr = Number.MIN_SAFE_INTEGER,
    count = 0;

  pairs.sort(([a, b], [c, d]) => b - d);

  for (let [a, b] of pairs) {
    if (a > curr) {
      curr = b;
      count += 1;
    }
  }

  return count;
};
