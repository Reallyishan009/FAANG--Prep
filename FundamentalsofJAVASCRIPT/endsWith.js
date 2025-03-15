//check if the following string ends with the given character or string

function solution(str, ending) {
    return str.endsWith(ending);
}

//If .endsWith() is not allowed, you can use slice():

function solution(str, ending) {
    return str.slice(-ending.length) === ending;
}
  

//sub-string method

function solution(str, ending) {
    // Extract the last `ending.length` characters from `str`
    let substring = str.substring(str.length - ending.length);
  
    // Compare the extracted substring with `ending`
    if (substring === ending) {
      return true;
    }
    return false;
  }
  