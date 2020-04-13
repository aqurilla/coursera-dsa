/*
For an array of numbers, we choose the two largest 
numbers x & y -

If x == y, both numbers are removed;
If x != y, number y is removed, and x 
stores the difference

Returns the final number in the array.
*/

const lastStoneWeight = function (stones) {
  let max_first = 0,
    max_second = 0;
  let position_first = 0,
    position_second = 0;

  while (stones.length > 1) {
    // find max and second max elems
    [max_first, max_second, position_first, position_second] = calcElems(
      stones
    );

    // if same delete both
    if (max_first === max_second) {
      if (position_first > position_second) {
        stones.splice(position_first, 1);
        stones.splice(position_second, 1);
      } else {
        stones.splice(position_second, 1);
        stones.splice(position_first, 1);
      }
    } else {
      // if different, replace max with diff and delete second max
      stones[position_first] = max_first - max_second;
      stones.splice(position_second, 1);
    }
  }
  if (stones.length !== 0) {
    return stones[0];
  } else {
    return 0;
  }
};

const calcElems = function (arr) {
  let max_first = 0,
    max_second = 0;
  let position_first = 0,
    position_second = 0;

  for (let i = 0; i < arr.length; i++) {
    elem = arr[i];
    if (elem > max_first) {
      max_first = elem;
      position_first = i;
    }
  }

  for (let i = 0; i < arr.length; i++) {
    elem = arr[i];
    if (elem > max_second && i !== position_first) {
      max_second = elem;
      position_second = i;
    }
  }

  return [max_first, max_second, position_first, position_second];
};
