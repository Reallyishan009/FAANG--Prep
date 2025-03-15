//1: using square root i.e Math.sqrt()
//2: using .isInteger() see if it is integer and not a number with decimals
//3: using Math.pow(number+1,2) , we increment the number as well as square it

function findNextSquare(sq) {
    let number = Math.sqrt(sq);
    
    if (Number.isInteger(number)) {
      return Math.pow(number + 1, 2);
    }
    
    return -1;
  }


  