package Stacks;

import java.util.Stack;

public class Q1CheckParanthesis {
    public static boolean areParenthesesBalanced(String expr) {
        Stack<Character> str = new Stack<>();
        for(int i =0;i<expr.length();i++){
            char current = expr.charAt(i);
            if(current == '(' || current == '[' || current == '{' ){
                str.push(current);
                continue;
            }

            if(str.isEmpty()){
                return false;
            }

            char check;

            switch (current){
                case ')':
                   check =str.pop();
                   if(check!='('){
                    return false;
                   }
                    break;
                case ']':
                   check =str.pop();
                   if(check!='['){
                    return false;
                   }
                   break;

                case '}':
                   check =str.pop();
                   if(check!='{'){
                    return false;
                   }
                   break;  

            }
        }

        return str.isEmpty();

    }
    public static void main(String[] args) {
        System.out.println(areParenthesesBalanced("()")); // true
        System.out.println(areParenthesesBalanced("()[]{}")); // true
        System.out.println(areParenthesesBalanced("{[()]}")); // true
        System.out.println(areParenthesesBalanced("")); // true
        System.out.println(areParenthesesBalanced("(]")); // false
        System.out.println(areParenthesesBalanced("([)]")); // false
        System.out.println(areParenthesesBalanced("{[(])}")); // false
        System.out.println(areParenthesesBalanced("(")); // false
    }
}

//T.C: O(n)
//S.C: O(n)