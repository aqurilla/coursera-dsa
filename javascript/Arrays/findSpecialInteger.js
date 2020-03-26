/*
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

Return that integer.
*/

const findSpecialInteger = function(arr) {
  const length = arr.length;

  arr_quantiles = [
    arr[0],
    arr[Math.floor(length / 4)],
    arr[Math.floor(length / 2)],
    arr[Math.floor((length * 3) / 4)]
  ];

  indexes = arr_quantiles.map(elem => arr.indexOf(elem));

  for (let index of indexes) {
    if (arr[index] === arr[index + Math.floor(length / 4)]) {
      return arr[index];
    }
  }
};
