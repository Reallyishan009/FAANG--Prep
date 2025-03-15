/*QUESTION
Take 2 strings s1 and s2 including only letters from a to z. 
Return a new sorted string (alphabetical ascending),
the longest possible, containing distinct letters -
each taken only once - coming from s1 or s2.

Examples:
a = "xyaabbbccccdefww"
b = "xxxxyyyyabklmopq"
longest(a, b) -> "abcdefklmopqwxy"
a = "abcdefghijklmnopqrstuvwxyz"
longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
*/

function longest(s1, s2) {
    return [...new Set(s1 + s2)] // Merge strings and remove duplicates
      .sort() // Sort alphabetically
      .join(""); // Convert back to a string
  }

/*
Let's break down the function step by step in depth:

1. Concatenating the Two Strings (s1 + s2)
s1 + s2
The + operator joins the two input strings into one longer string.
Example:
let s1 = "abc";
let s2 = "bde";
let merged = s1 + s2; // "abcbde"
Why?

We want to combine both strings before extracting unique characters.
2. Removing Duplicates Using new Set()
[...new Set(s1 + s2)]
Understanding Set

A Set is a JavaScript data structure that only stores unique values.
new Set(s1 + s2) creates a Set where duplicate characters are automatically removed.
Example:

let merged = "abcbde";
let uniqueChars = new Set(merged); // {'a', 'b', 'c', 'd', 'e'}
However, a Set is not an array, so we convert it back to an array using [...new Set()].
How [...new Set()] Works:

The spread operator (...) takes all elements from the Set and places them into an array.
Example:
let uniqueArray = [...new Set("abcbde")]; // ['a', 'b', 'c', 'd', 'e']
Why?

We use Set to filter out duplicate characters, ensuring each letter appears only once.
3. Sorting Alphabetically with .sort()
.sort()
The .sort() method sorts an array in place.
By default, .sort() converts elements to strings and sorts them in Unicode order.
Example:

let arr = ['b', 'a', 'd', 'c'];
arr.sort(); // ['a', 'b', 'c', 'd']
Why?

We want our final output to have letters in alphabetical order.
4. Joining the Array Back into a String with .join("")
.join("")
.join("") converts an array back into a string.
The argument "" ensures there are no spaces between characters.
Example:

let sortedArray = ['a', 'b', 'c', 'd', 'e'];
let result = sortedArray.join(""); // "abcde"
Why?

The final output should be a string, not an array.
Final Execution Breakdown
Input:

longest("aretheyhere", "yestheyarehere");
Step-by-Step Execution:

Concatenation
"aretheyhere" + "yestheyarehere" = "aretheyhereyestheyarehere"
Removing Duplicates
new Set("aretheyhereyestheyarehere") → {'a', 'r', 'e', 't', 'h', 'y', 's'}
Converting Set to Array
[...new Set("aretheyhereyestheyarehere")] → ['a', 'r', 'e', 't', 'h', 'y', 's']
Sorting the Array
['a', 'e', 'h', 'r', 's', 't', 'y']
Joining the Array into a String
"aehrsty"
Final Output:

"aehrsty"
Complete Explanation in One Flow
Concatenates both input strings into one.
Removes duplicate characters using new Set().
Converts the Set into an array with [...new Set()].
Sorts the array alphabetically.
Joins the array back into a string using .join("").
Returns the final sorted string.


*/
