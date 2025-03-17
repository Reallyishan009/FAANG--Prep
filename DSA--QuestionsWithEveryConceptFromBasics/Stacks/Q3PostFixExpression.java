package Stacks;

import java.util.Stack;

public class Q3PostFixExpression {
    public static int postfix(String expr){
        Stack<Integer> stack = new Stack<>();

        for(char ch : expr.toCharArray()){
            if(Character.isDigit(ch)){
                stack.push(ch-'0');
            }
            else{
                int b = stack.pop();
                int a = stack.pop();
                switch(ch){
                    case '+' : stack.push(a+b);break;
                    case '-' : stack.push(a-b);break;
                    case '*' : stack.push(a*b); break;
                    case '/' : stack.push(a/b);break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expr1 = "231*+9-"; 
        System.out.println("Result: " + postfix(expr1)); // Output: -4
    }
}


/*
 * What is ch - '0' in Java?
In Java, ch - '0' is a common way to convert a character digit (e.g., '3') to its integer value (e.g., 3).

Explanation:

Characters in Java are stored as ASCII (or Unicode) values.
The ASCII value of '0' is 48, '1' is 49, '2' is 50, ..., '9' is 57.
Subtracting '0' (which is 48) from any digit character gives its actual integer value.
Example:

char ch = '5';
int num = ch - '0'; // Converts '5' to integer 5
System.out.println(num); // Output: 5
ASCII Breakdown:

Character	ASCII Value	Calculation (ch - '0')	Integer Output
'0'	48	48 - 48	0
'1'	49	49 - 48	1
'2'	50	50 - 48	2
'5'	53	53 - 48	5
'9'	57	57 - 48	9
Why Use ch - '0' Instead of Integer.parseInt()?
✅ Faster: ch - '0' is a simple arithmetic operation, whereas Integer.parseInt() involves function calls.
✅ Memory Efficient: No need to create a new String object or call methods.
✅ Useful for Single Characters: Works great when processing individual characters in a loop.
 */