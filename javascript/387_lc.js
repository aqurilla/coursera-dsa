/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
*/
/**
 * @param {string} s
 * @return {number}
 */
const firstUniqChar = function (s) {
  let myMap = new Map();
  let uniqueMap = new Map();

  [...s].forEach((c, idx) => {
    if (!uniqueMap.has(c)) {
      uniqueMap.set(c, true);
      myMap.set(c, idx);
    } else {
      myMap.delete(c);
    }
  });

  if (!myMap.size) return -1;

  for (let [key, val] of myMap.entries()) {
    return val;
  }
};
