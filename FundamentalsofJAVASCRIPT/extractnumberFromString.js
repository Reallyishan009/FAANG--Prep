// GET NUMBER FROM STRING

//1:JavaScript match method with regEx 

let matches = str.match(/(\d+)/);

//2:reduce() method

function extractnumber() {
    // Input string
    let str = "jhkj7682834";
    let c = "0123456789";
    console.log(str);
    function check(x) {
        return c.includes(x) ? true : false;
    }
    let matches = [...str].reduce(
        (x, y) => (check(y) ? x + y : x),"");

    // Display output if number extracted
    if (matches) {
        console.log(matches);
    }
}

