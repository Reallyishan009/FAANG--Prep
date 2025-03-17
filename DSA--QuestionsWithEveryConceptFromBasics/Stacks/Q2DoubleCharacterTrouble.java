package Stacks;

import java.util.Stack;

public class Q2DoubleCharacterTrouble {
    public static String checkDoubleCharacter(String expr){
        Stack<Character> stack = new Stack<>();
        for(char ch : expr.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==ch ){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        StringBuilder STR = new StringBuilder();
        for(char c : stack){
            STR.append(c);
        }
        return STR.toString();
    }
    
    public static void main(String[] args) {
        testCheckDoubleCharacter();
    }

    public static void testCheckDoubleCharacter() {
        String result1 = Q2DoubleCharacterTrouble.checkDoubleCharacter("abbaca");
        assert result1.equals("ca") : "Test case 1 failed";

        String result2 = Q2DoubleCharacterTrouble.checkDoubleCharacter("azxxzy");
        assert result2.equals("ay") : "Test case 2 failed";

        String result3 = Q2DoubleCharacterTrouble.checkDoubleCharacter("aabbcc");
        assert result3.equals("") : "Test case 3 failed";

        String result4 = Q2DoubleCharacterTrouble.checkDoubleCharacter("abcddcba");
        assert result4.equals("") : "Test case 4 failed";

        String result5 = Q2DoubleCharacterTrouble.checkDoubleCharacter("abccba");
        assert result5.equals("") : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}


//T.C = O(n);
//S.C = O(n);