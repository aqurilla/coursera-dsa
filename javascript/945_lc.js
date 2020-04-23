/*
Given an array of integers A, a move consists 
of choosing any A[i], and incrementing it by 1.

Return the least number of moves to make every 
value in A unique.
*/
/**
 * @param {number[]} A
 * @return {number}
 */
const minIncrementForUnique = function (A) {
  let moves = 0;

  A.sort((a, b) => a - b);

  for (let i = 1; i < A.length; i++) {
    if (A[i] <= A[i - 1]) {
      moves += A[i - 1] + 1 - A[i];
      A[i] = A[i - 1] + 1;
    }
  }

  return moves;
};
