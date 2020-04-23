/*
On an 8x8 chessboard, there can be multiple 
Black Queens and one White King.

Given an array of integer coordinates queens 
that represents the positions of the Black Queens, 
and a pair of coordinates king that represent the 
position of the White King, return the coordinates 
of all the queens (in any order) that can attack 
the King.
*/
/**
 * @param {number[][]} queens
 * @param {number[]} king
 * @return {number[][]}
 */
const queensAttacktheKing = function (queens, king) {
  let myDict = {};
  let soln = [];
  let x, y;

  queens.forEach((coord) => {
    myDict[coord] = true;
  });

  for (let i of [-1, 0, 1]) {
    for (let j of [-1, 0, 1]) {
      for (let k of [...Array(8).keys()]) {
        x = king[0] + i * k;
        y = king[1] + j * k;
        if ([x, y] in myDict) {
          soln.push([x, y]);
          break;
        }
      }
    }
  }

  return soln;
};
