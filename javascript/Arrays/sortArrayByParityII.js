/*
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
*/

const sortArrayByParityIIa = function(A) {
  // inplace solution
  // 2-pointer approach
  let i = 0;
  let j = 0;
  let temp;

  while (i < A.length) {
    if (i % 2 !== A[i] % 2) {
      j = i + 1;
      while (i % 2 !== A[j] % 2 && j < A.length) {
        j++;
      }
      // swap elems at i and j
      temp = A[j];
      A[j] = A[i];
      A[i] = temp;
    }
    i++;
  }

  return A;
};

const sortArrayByParityIIb = function(A) {
  // maintain two pointers - odd and even
  const result = new Array(A.length);

  // pass through given array
  for (let i = 0, odd = 1, even = 0; i < A.length; i++) {
    if (A[i] % 2 === 0) {
      result[even] = A[i];
      even += 2;
    } else {
      result[odd] = A[i];
      odd += 2;
    }
  }

  return result;
};
