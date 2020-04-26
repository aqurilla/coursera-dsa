/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.
*/
/**
 * @param {number[]} nums
 * @return {boolean}
 */
const canJump = function (nums) {
  let jumpLimit = 0;
  for (let i = 0; i < nums.length; i++) {
    if (i > jumpLimit) return false;
    jumpLimit = Math.max(jumpLimit, i + nums[i]);
  }
  return true;
};
