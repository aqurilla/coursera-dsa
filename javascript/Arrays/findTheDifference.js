/*
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.
*/

var findTheDifference = function(s, t) {
  const dict1 = {};

  for (let idx in t) {
    ch = t[idx];
    dict1[ch] = (dict1[ch] || 0) + 1;
  }

  for (let idx in s) {
    ch = s[idx];
    if (!(ch in dict1)) {
      return ch;
    } else {
      dict1[ch] = dict1[ch] - 1;
    }
  }

  for (let [key, value] of Object.entries(dict1)) {
    if (value > 0) {
      return key;
    }
  }
};
