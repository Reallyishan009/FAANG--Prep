//WHILE REMOVING A GIVEN CHARACTER

//1:Using replace() – Removes First Occurrence

s = "IshanTripathi";
res = s.replace(/I/i, "");
console.log(res);

//2:Using split() and join() – Removes All

let s = "IshanTripathi";
let res = s.split("I").join("");
console.log(res);

//3:Using Array.filter() – Removes All

let s = "IshanTripathi";
let c = 'I';
let res = Array.from(s)
    .filter(char => char !== c)
    .join('');
console.log(res);

//HOW TO REMOVE first AND  last  INDEX

//1:Using the slice() Method

function removeCharacter(str) {
    let newString = str.slice(0, -1);
    return newString;

}
let str = "IshanTripathi";
console.log(removeCharacter(str)); //string.slice( startingIndex, endingIndex )

//2: Using substring() Method

function removeCharacter(str) {
    let newString = str.substring(0, str.length - 1);
    return newString;

} //this method will help to get whatever range you want

//3:Using split() and join()

function removeCharacter(str) {
    let splitString = str.split('')
    splitString.pop();
    return splitString.join('');

}

//4:Using Regular Expression

function removeLastCharacter(str) {
    return str.replace(/.$/, '');
}

//5:Using Array.from() Method

function removeCharacter(str) {
    let arr = Array.from(str);
    arr.pop();
    return arr.join('');
}



//QUESTIONS OF THIS APPROACH:

//1: REMOVE EXCLAIMATION MARKS

function removeExclamationMarks(s) {
    return s.replace(/!/g, ""); // Replace all '!' with an empty string
}
//The g flag (global flag) ensures that all occurrences are removed.

//2: Remove/replace numbers with 0 & 1

function fakeBin(x) {
    return x
      .split("") // Convert string into an array of characters
      .map(num => (num < '5' ? '0' : '1')) // Replace digits accordingly
      .join(""); // Convert the array back into a string
  }