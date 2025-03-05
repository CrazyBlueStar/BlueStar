package org.example;
import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        //Creates stack
        Stack<Character> stack = new Stack<>();

         //Goes through every char for validation
        for (char c : s.toCharArray()) {
             //Pushes correct brackets into the stack
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
            //If empty or stack pop doesn't match c then returns false
        }
        return stack.isEmpty();
    }
}