/*
Given an integer array nums, find the contiguous 
subarray (containing at least one number) which 
has the largest sum and return its sum.
*/

const maxSubArray = function (nums) {
  // [-2,1,-3,4,-1,2,1,-5,4]
  if (!nums.length) {
    return 0;
  }

  let sum = nums[0];
  let maxSum = sum;

  for (let i = 1; i < nums.length; i++) {
    if (sum > 0) {
      sum += nums[i];
    } else {
      sum = nums[i];
    }
    maxSum = Math.max(sum, maxSum);
  }

  return maxSum;
};
