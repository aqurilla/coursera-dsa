/*
Given two binary search trees root1 and root2.

Return a list containing all the integers from 
both trees sorted in ascending order.
*/
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {number[]}
 */
const getAllElements = function (root1, root2) {
  let arr1 = inOrder(root1);
  let arr2 = inOrder(root2);

  return merge(arr1, arr2);
};

const merge = (arr1, arr2) => {
  let mergedArr = [];

  let i = 0,
    j = 0;

  while (i < arr1.length && j < arr2.length) {
    if (arr1[i] < arr2[j]) {
      mergedArr.push(arr1[i]);
      i++;
    } else {
      mergedArr.push(arr2[j]);
      j++;
    }
  }
  while (i < arr1.length) {
    mergedArr.push(arr1[i]);
    i++;
  }
  while (j < arr2.length) {
    mergedArr.push(arr2[j]);
    j++;
  }
  return mergedArr;
};

const inOrder = (root) => {
  let arr = [];

  const traverse = (root) => {
    if (!root) return;
    traverse(root.left);
    arr.push(root.val);
    traverse(root.right);
  };

  traverse(root);
  return arr;
};
