/*
Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree. 

We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
*/
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number[]} arr
 * @return {boolean}
 */
const isValidSequence = function (root, arr) {
  const n = arr.length - 1;

  const checkValidity = (node, k) => {
    // check current val
    if (!node || node.val !== arr[k] || k > n) {
      return false;
    }

    // check if condition reached
    if (k === n && !node.left && !node.right) {
      return true;
    }

    // check validity of left and right
    return checkValidity(node.left, k + 1) || checkValidity(node.right, k + 1);
  };

  return checkValidity(root, 0);
};
