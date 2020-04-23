/*
Given a binary tree root and an integer target, 
delete all the leaf nodes with value target.
*/
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} target
 * @return {TreeNode}
 */
const removeLeafNodes = function (root, target) {
  if (root.left) {
    root.left = removeLeafNodes(root.left, target);
  }
  if (root.right) {
    root.right = removeLeafNodes(root.right, target);
  }

  if (!root.left && !root.right && root.val === target) {
    return null;
  }

  return root;
};
