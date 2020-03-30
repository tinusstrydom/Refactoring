/**Refactoring
 * Tinus Strydom
 * Program that returns calculation in reverse polish notation
 */
package Refactoring;

import java.util.*;

public class RPN{
	
    String rpnExpr;
    
    //Constructor for RPN class
    public RPN(String rpnExpr) {
    	this.rpnExpr = rpnExpr;
    }
    
    //Method to evaluate RPN expression string
    public void evalRPN(String expr){
    	//replaced all the spaces
		expr = expr.replaceAll("\\s", "");
		
		//Create and instantiate Stack
		Deque<Double> stack = new LinkedList<Double>();
		
		//loop through string expression entered by user
		for(int i = 0; i < expr.length(); i++){
			/*Create variables 
			 * number for use if it is a number in expression
			 * firstOperand and secondOperand used for assigning popped values from stack
			 * charConvertString used for converting temp character to string  
			 */
			double number, secondOperand, firstOperand;
			String charConvertString;
			
			/* If character in the Expression String is a digit, assigned it to temp char variable
			 * then assigned it to charConvertString using the String valueOg method to convert character to string
			 * assigned to number and parse to Double and push to stack
			 * else we check if the character in the expression is arithmetic operator or to the power operator
			 * each else used the last 2 numbers from the stack and calculate according to user input and push number back to stack 
			 * 
			 */
			if(Character.isDigit(expr.charAt(i))) {
				char temp = expr.charAt(i);
				charConvertString = String.valueOf(temp);
				number = Double.parseDouble(charConvertString);
				stack.push(number);
				
			}else if(expr.charAt(i) == '+')  {
				secondOperand = stack.pop();
				firstOperand = stack.pop();
				stack.push(firstOperand + secondOperand);
			}else if(expr.charAt(i) == '-')  {
				secondOperand = stack.pop();
				firstOperand = stack.pop();
				stack.push(firstOperand - secondOperand);
			}else if(expr.charAt(i) == '*')  {
				secondOperand = stack.pop();
				firstOperand = stack.pop();
				stack.push(firstOperand * secondOperand);
			}else if(expr.charAt(i) == '/')  {
				secondOperand = stack.pop();
				firstOperand = stack.pop();
				stack.push(firstOperand / secondOperand);
			}else if(expr.charAt(i) == '^')  {
				secondOperand = stack.pop();
				firstOperand = stack.pop();
				stack.push(Math.pow(firstOperand, secondOperand));
			}
			//Output what is in stack 
			System.out.println(stack);
		}    
		/* Output what is at the top of stack after calculation equals sum of
		 * the expression
		 */
		System.out.println(stack.peek());
    }
		
    public static void main(String[] args) {
    	while(true) {
    		Scanner scnrInput = new Scanner(System.in);
    		System.out.println("Enter RPN expression or \"quit\".");
			String rpnExpr  = scnrInput.nextLine();
			if(rpnExpr.equals("quit")) {
				break;
			}else{
				RPN calc = new RPN(rpnExpr); 
				calc.evalRPN(rpnExpr);
			}	
		}
	}
}