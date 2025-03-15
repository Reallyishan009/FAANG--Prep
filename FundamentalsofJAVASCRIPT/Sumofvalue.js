//Finding Sum of squares

function squareSum(numbers) {
    return numbers
      .map(num => Math.pow(num, 2))  // Map each number to its square
      .reduce((sum, num) => sum + num, 0); // Sum up all squares
  }
/*
Understanding reduce() in JavaScript
The .reduce() method in JavaScript is used to accumulate values in an array into a single output.

Syntax

array.reduce((accumulator, currentValue) => {
    logic
}, initialValue);


accumulator → Stores the accumulated result (updated in each iteration).
currentValue → The current element of the array being processed.
initialValue → The starting value for the accumulator (optional but recommended).
*/