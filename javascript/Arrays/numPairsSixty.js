/*
In a list of songs, the i-th song has a duration of time[i] seconds. 

Return the number of pairs of songs for which their total duration 
in seconds is divisible by 60.
*/

var numPairsDivisibleBy60 = function(time) {
  let result = 0;
  const myMap = new Map();

  // Obtain map of array elements
  time.forEach(elem => {
    myMap.set(elem % 60, (myMap.get(elem % 60) || 0) + 1);
  });

  // Loop through combinations and count
  // possible ones
  for (let i = 1; i < 30; i++) {
    result += (myMap.get(i) || 0) * (myMap.get(60 - i) || 0);
  }

  // For cases 0 and 30, add n*(n-1)/2
  result += ((myMap.get(0) || 0) * ((myMap.get(0) || 0) - 1)) / 2;
  result += ((myMap.get(30) || 0) * ((myMap.get(30) || 0) - 1)) / 2;

  return result;
};
