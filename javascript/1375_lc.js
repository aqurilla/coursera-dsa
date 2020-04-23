/*
There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are turned off.

At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.

Return the number of moments in which all turned on bulbs are blue.
*/

/**
 * @param {number[]} light
 * @return {number}
 */
const numTimesAllBlue = function (light) {
  if (!light.length) return 0;
  let max = 0,
    sum = 0,
    reqd = 0,
    moments = 0;

  for (let k of light) {
    max = Math.max(max, k);
    sum += k;
    reqd = (max * (max + 1)) / 2;
    if (sum === reqd) moments += 1;
  }

  return moments;
};
