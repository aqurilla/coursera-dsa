/*
Given an integer array arr and a target value target, return the integer value such that when we change all the integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.

In case of a tie, return the minimum such integer.

Notice that the answer is not neccesarilly a number from arr.
*/

/**
 * @param {number[]} arr
 * @param {number} target
 * @return {number}
 */
const findBestValue = function (arr, target) {
  if (!arr.length) return 0;
  let sum = 0,
    min = 10 ** 5,
    max = 0,
    avg,
    count = 0,
    csum = 0;

  for (let k of arr) {
    sum += k;
    min = Math.min(min, k);
    max = Math.max(max, k);
  }

  avg = Math.round(target / arr.length);

  // case: sum <= target
  if (sum <= target) return max;

  // case: avg <= minimum
  if (avg <= min) return avg;

  for (let k of arr) {
    if (k < avg) {
      csum += k;
    } else {
      count += 1;
    }
  }

  let soln = (target - csum) / count;

  return soln % 1 === 0.5 ? Math.floor(soln) : Math.round(soln);
};
