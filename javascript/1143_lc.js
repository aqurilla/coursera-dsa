/*
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

If there is no common subsequence, return 0.
*/
/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
const longestCommonSubsequence = function (text1, text2) {
  // create 2d matrix
  const grid_2d = [];

  for (let i = 0; i <= text1.length; i++) {
    grid_2d[i] = [];

    for (let j = 0; j <= text2.length; j++) {
      if (i === 0 || j === 0) {
        grid_2d[i][j] = 0;
      } else {
        if (text1[i - 1] === text2[j - 1]) {
          // matching chars
          grid_2d[i][j] = grid_2d[i - 1][j - 1] + 1;
        } else {
          // non-matching chars
          grid_2d[i][j] = Math.max(grid_2d[i - 1][j], grid_2d[i][j - 1]);
        }
      }
    }
  }

  return grid_2d[text1.length][text2.length];
};
