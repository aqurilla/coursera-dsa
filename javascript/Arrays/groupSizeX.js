/*
In a deck of cards, each card has an integer written on it.
Return true if and only if you can choose X >= 2 such that 
it is possible to split the entire deck into 1 or more groups
 of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.
*/

const hasGroupsSizeX = function(deck) {
  const myMap = new Map();

  deck.forEach(elem => {
    myMap.set(elem, (myMap.get(elem) || 0) + 1);
  });

  let result = 0;
  for (let value of myMap.values()) {
    result = gcd(result, value);
  }

  return result > 1;
};

const gcd = (a, b) => {
  if (!b) {
    return a;
  }
  return gcd(b, a % b);
};
