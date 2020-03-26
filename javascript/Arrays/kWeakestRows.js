/*
Given a m * n matrix mat of ones and zeros, return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
Weak rows contain less 1s. All 1s are placed at the beginning of the row.
*/

var kWeakestRows = function(mat, k) {
  if (mat.length === 0) {
    return [];
  }

  const result = [];
  const m = mat.length;
  const n = mat[0].length;
  const myDict = {};

  // search column wise because 1s are
  // always at the front
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (mat[j][i] === 0 && !(j in myDict)) {
        result.push(j);
        myDict[j] = true;
      }
      if (result.length === k) {
        return result;
      }
    }
  }

  // Add remaining rows till limit
  // Remaining rows will have all 1s
  i = 0;
  while (result.length < k && i < m) {
    if (mat[i][n - 1] === 1) {
      result.push(i);
    }
    i++;
  }

  return result;
};
