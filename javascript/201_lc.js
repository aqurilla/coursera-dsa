/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, 
return the bitwise AND of all numbers in this range, 
inclusive.
/*

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
const rangeBitwiseAnd = function (m, n) {
  if (m === 0) return 0;

  let counter = 0;

  while (m < n) {
    m = m >>> 1;
    n = n >>> 1;
    counter += 1;
  }

  return n === 0 ? 0 : n << counter;
};
