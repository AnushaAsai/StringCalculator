/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringcalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Aunsha Asaithambi
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testEmptyString() {
        Calculator c = new Calculator();
        assertEquals(0,c.add(""));
    }
    
    @Test
    public void testNonEmptyString() {
        Calculator c = new Calculator();
        assertEquals(8,c.add("1,2,5"));
    }
    
    @Test
    public void testNewLineString() {
        Calculator c = new Calculator();
        assertEquals(6,c.add("1\n,2,3"));
    }
    
    @Test
    public void testAnotherNewLineString() {
        Calculator c = new Calculator();
        assertEquals(7,c.add("1,\n2,4"));
    }
    
    @Test
    public void testDelimiterString() {
        Calculator c = new Calculator();
        assertEquals(8,c.add("//;\n1;3;4"));
    }
    
    @Test
    public void testAnotherDelimiterString() {
        Calculator c = new Calculator();
        assertEquals(13,c.add("//@\n2@3@8"));
    }
    
    @Test
    public void testArbitraryLengthDelimiterString() {
        Calculator c = new Calculator();
        assertEquals(6,c.add("//***\n1***2***3"));
    }
    
    @Test
    public void testMultipleDelimiterString() {
        Calculator c = new Calculator();
        assertEquals(6,c.add("//$,@\n1$2@3"));
    }
    
    @Test
    public void testGreaterNumberString() { //number>1000
        Calculator c = new Calculator();
        assertEquals(2,c.add("2,1001"));
    }
    
    @Test
    public void testNegativeNumber() { //number>1000
        Calculator c = new Calculator();
        try{
            c.add("1,2,-5,-4");
            fail("This use case should have failed, exception should be thrown");
        }catch (IllegalArgumentException ex){
            assertEquals("This is expected because: ",ex.getMessage());
        }
    }
    
}
