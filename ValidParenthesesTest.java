package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidParenthesesTest {

    ValidParentheses vp = new ValidParentheses();

    //Default test
    @Test
    public void testIsValid() {
        //Valid
        assertTrue(vp.isValid("()"));
        assertTrue(vp.isValid("()[]{}"));
    }
    //Default Test
    @Test
    public void testIsInValid() {
        //Invalid
        assertFalse(vp.isValid("(]"));
        assertFalse(vp.isValid("([)]"));

    }
    //Default test
    @Test
    public void testEmptyString() {
        //Valid if empty
        assertTrue(vp.isValid(""));
    }
    //Additional test
    @Test
    public void testSingleParenthesis() {
        //Invalid
        assertFalse(vp.isValid("("));
        assertFalse(vp.isValid(")"));
    }
    //Additional test
    @Test
    public void testUnmatchedParentheses() {
        //Invalid
        assertFalse(vp.isValid("(((("));
        assertFalse(vp.isValid("))))"));
    }
    }


