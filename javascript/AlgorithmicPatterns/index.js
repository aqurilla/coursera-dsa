/*
Problem Solving Steps
=====================
1. Understand the problem (inputs, outputs)
2. Explore examples
3. Break down steps
4. Solve or Simplify
5. Refactor
*/

/*
Problem Solving Patterns
========================
*/

// Frequency Counter
same = (arr1, arr2) => {
  // differing lengths case
  if (arr1.length !== arr2.length) {
    return false;
  }

  const freq1 = {};
  const freq2 = {};

  for (let val of arr1) {
    freq1[val] = (freq1[val] || 0) + 1;
  }
  for (let val of arr2) {
    freq2[val] = (freq2[val] || 0) + 1;
  }

  for (let key in freq1) {
    if (!(key ** 2 in freq2)) {
      return false;
    }

    if (freq1[key] !== freq2[key ** 2]) {
      return false;
    }
  }
  return true;
};

// Anagrams
anagram = (str1, str2) => {
  // edge case differing lengths
  if (str1.length !== str2.length) {
    return false;
  }

  // Make freq counters for both strings
  const freq1 = {};
  const freq2 = {};

  for (let val of str1) {
    freq1[val] = (freq1[val] || 0) + 1;
  }

  for (let val of str2) {
    freq2[val] = (freq2[val] || 0) + 1;
  }

  // Compare freq counters to see that all
  // counts match with same value
  for (let key in freq1) {
    if (freq1[key] !== freq2[key]) {
      return false;
    }
  }

  return true;
};

// Multiple Pointers
// In a sorted array, find the first pair
// of elements that sums to 0

function sumZero(arr) {
  // start with pointers at both ends
  let left = 0;
  let right = arr.length - 1;

  // loop while left is less than right
  while (left < right) {
    let sum = arr[left] + arr[right];
    if (sum === 0) {
      return [arr[left], arr[right]];
    } else if (sum > 0) {
      right--;
    } else {
      left++;
    }
  }
}

function countUniqueValues(arr) {
  // initialize two pointers at start of array
  let p1 = 0;
  let p2 = 0;
  let result = 0;

  // increment till length of array
  while (p1 < arr.length) {
    result += 1;
    if (p1 === arr.length - 1) {
      break;
    }
    while (p2 < arr.length && arr[p1] === arr[p2]) {
      p2++;
    }
    p1 = p2;
  }

  return result;
}

// Moving Window
// Calculate max sum of n consecutive elements in array (O(n))
function maxSubarraySum(arr, num) {
  // if n > length of array, return
  let maxSum = 0;
  let tempSum = 0;
  if (num > arr.length) {
    return null;
  }

  // take sum of 1st n elems
  for (let i = 0; i < num; i++) {
    maxSum += arr[i];
  }
  tempSum = maxSum;
  // loop from n till end
  for (i = num; i < arr.length; i++) {
    // remove first elem, add current elem
    tempSum = tempSum + arr[i] - arr[i - num];
    maxSum = Math.max(maxSum, tempSum);
  }

  return maxSum;
}

// Divide and Conquer
// eg. Binary Search, Sorting etc.
