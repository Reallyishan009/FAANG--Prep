// while handeling multiple cases use these:

//1: SWITCH()

function basicOp(operation, value1, value2) {
    switch (operation) {
        case '+':
            return value1 + value2;
        case '-':
            return value1 - value2;
        case '*':
            return value1 * value2;
        case '/':
            return value1 / value2;
        default:
            return 0;
    }
}

// Switching Details
// If multiple cases match a case value, the first case is selected.
// If no matching cases are found, the program continues to the default label.
// If no default label is found, the program continues to the statement(s) after the switch
//Switch cases use strict comparison (===)
