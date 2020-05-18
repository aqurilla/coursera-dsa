/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
*/
/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
const checkInclusion = function (s1, s2) {
  let arr1 = new Array(26).fill(0);
  let start = 0,
    end = s1.length;

  if (s1.length > s2.length) return false;

  for (let i = 0; i < s1.length; i++) {
    arr1[s1.charCodeAt(i) - 97] = (arr1[s1.charCodeAt(i) - 97] || 0) + 1;
    arr1[s2.charCodeAt(i) - 97] = (arr1[s2.charCodeAt(i) - 97] || 0) - 1;
  }

  if (arrayZeros(arr1)) return true;

  // Sliding window
  while (end < s2.length) {
    arr1[s2.charCodeAt(start) - 97] =
      (arr1[s2.charCodeAt(start) - 97] || 0) + 1;
    arr1[s2.charCodeAt(end) - 97] = (arr1[s2.charCodeAt(end) - 97] || 0) - 1;
    if (arrayZeros(arr1)) return true;
    start++;
    end++;
  }

  return false;
};

const arrayZeros = function (arr1) {
  for (let i = 0; i < arr1.length; i++) {
    if (arr1[i] !== 0) return false;
  }

  return true;
};
