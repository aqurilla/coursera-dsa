/*
Given two arrays, write a function to compute their intersection.
*/

var intersect = function(nums1, nums2) {
  let result = [];
  const dict1 = {};

  for (let i of nums1) {
    dict1[i] = (dict1[i] || 0) + 1;
  }

  for (let j of nums2) {
    if (j in dict1 && dict1[j] > 0) {
      result.push(j);
      dict1[j] = dict1[j] - 1;
    }
  }

  return result;
};
