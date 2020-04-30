/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
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
 * @return {number}
 */
const maxPathSum = function (root) {
  let maxSum = Number.MIN_SAFE_INTEGER;

  function findMaxSum(node) {
    if (!node) return 0;

    let leftSum = findMaxSum(node.left);
    let rightSum = findMaxSum(node.right);

    let nodeSum = leftSum + rightSum + node.val;

    let maxNodeVal = Math.max(
      node.val,
      node.val + leftSum,
      node.val + rightSum,
      nodeSum
    );

    maxSum = Math.max(maxNodeVal, maxSum);

    return Math.max(node.val, node.val + leftSum, node.val + rightSum);
  }

  maxSum = Math.max(findMaxSum(root), maxSum);

  return maxSum;
};
