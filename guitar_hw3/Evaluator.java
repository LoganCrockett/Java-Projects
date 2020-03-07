import java.util.Scanner;
import java.lang.IllegalArgumentException;

public class Evaluator {
	//Stacks to use for algorithms
	//Be sure to clear the stacks after each usage!
	// you will also need to initialize them before use.
	private static Stack<Double> valStack;
	private static Stack<Character> opStack;
		
	//method to calculate and return y op x
	//call this method from the evalPostfix() method
	private static double doOp(double x, double y, String operator) throws IllegalArgumentException {
		/*
		 * Created by: Codename: Guitar
		 * On: 3/6/20
		 * CPSC 3200
		 */
		char op = operator.charAt(0);
		double answer = 0.0;//Initialize the answer for our expression
		//complete method
		//Switch between the type of operation we are performing
		switch(op) {
		case '+':
			answer = (y + x);break;
		case '-':
			answer = (y - x);break;
		case '*':
			answer = (y * x);break;
		case '/':
			answer = (y / x);break;
		case '^':
			answer =  Math.pow(y, x);break;
		}
		return answer;
	}
	
	/**
	 * Evaluates expressions inputed from the user using postfix notation
	 * @exception IllegalArgumentException Thrown if there are too many, or not enough operators
	 */
	public static void evalPostfix() throws IllegalArgumentException {
		/*
		 * Created by: Codename: Guitar
		 * On: 3/6/20
		 * CPSC 3200
		 */
		//prompt the user and accept a String, then evaluate it.
		boolean quit = false;//Sentinel value for loop
		String operands = "+-*/^";//String that contains all valid operands for input
		valStack = new LinkedStack<Double>();//Create the stack to be used
		do {
			//Start by initializing the stacks
			//valStack = new LinkedStack<Double>();
			
			//Get the input from the user
			Scanner lineInput = new Scanner(System.in);//Create a scanner to get a line of input from user
			System.out.print("Please enter a valid Postfix Expression: ");
			String lineExpression = lineInput.nextLine();
			//Create a scanner object to advance through the line of input
			Scanner expression = new Scanner(lineExpression);
			
			//Evaluate the line and push values onto the stack
			while(expression.hasNext()) {
				String potentialValue = expression.next();//Grab the next token value
				
				//Start by checking the length; if it is one, then check if it is an operand or a number
				if (potentialValue.length() == 1) {
					//If so, then determine if it is an operator
					boolean isOperand = false;//Sentinel flag for loop
					for (int i = 0; i < operands.length() && !isOperand;i++) {
						if (operands.charAt(i) == potentialValue.charAt(0)) {
							//If so, then call doOp, an push the result onto the value stack
							isOperand = true;//Set to true so we exit the loop
							
							//Test for correct input of operators before performing operation
							
							//If there is only one value, then we have too many operators
							//Throw an exception after closing the input scanners
							if (valStack.size() <= 1) {
								expression.close();
								lineInput.close();
								throw new IllegalArgumentException("Too many operators");
							}
							//Otherwise, perform the operation, and push the value
							else {
							valStack.push(doOp(valStack.pop(),valStack.pop(),potentialValue));
							}
						}
					}
					//If it did not perform an operation, then add the value to the stack
					if (!isOperand) {
						valStack.push(Double.valueOf(potentialValue));
					}
				}
				/*
				 * Otherwise,the length is greater than one, meaning it is a number.
				 * we can push it onto the stack
				 */
				else {
					valStack.push(Double.valueOf(potentialValue));
				}
			}
			
			//Check if the stack has more than one value on it
			//If so, then we did not have enough operators
			//Throw an exception after closing input scanners
			if (valStack.size() > 1) {
				lineInput.close();
				expression.close();
				throw new IllegalArgumentException("Not enough operators.");
			}
			
			//At this point, we can print the calculation, which will be the only value on the stack
			//By popping this value, we initialize the stack back to zero
			System.out.println("Calculation: " + valStack.pop());
			
			//If the user doesn't want to continue, then set quit to true,
			// close the input scanners, and exit the loop
			System.out.println("\n(E)valuate another or (Q)uit: ");
			String quitInput = lineInput.next();
			if (quitInput.charAt(0) == 'Q' || quitInput.charAt(0) == 'q') {
				expression.close();
				lineInput.close();
				quit = true;
			}
		} while(!quit);	
		return;
	}
	
	
	/*
	 * Postfix Evaluation Methods Above ^
	 * Infix Evaluation Methods Below
	 */
			
	public static void evalInfix() throws IllegalArgumentException {
		/*
		 * Created by: Codename: Guitar
		 * On: 3/6/20
		 * CPSC 3200
		 */
		//prompt the user and accept a String, then evaluate it.
		//you can use the same code as in the evalPostfix() method
		//for accepting user input and breaking it into tokens
		boolean quit = false;//Sentinel value for loop
		valStack = new LinkedStack<Double>();//Create the stack to be used for values
		opStack = new LinkedStack<Character>();//Create the stack to be used for operators
		
		do {
			//Get the input from the user
			Scanner lineInput = new Scanner(System.in);//Create a scanner to get a line of input from user
			System.out.print("Please enter a valid Infix Expression: ");
			String lineExpression = lineInput.nextLine();
			//Create a scanner object to advance through the line of input
			Scanner expression = new Scanner(lineExpression);
			
			//Evaluate the line and push values onto the stacks
			while(expression.hasNext()) {
				String potentialValue = expression.next();//Grab the next token value
				
				//If it is a left parentheses, then push it onto the opstack
				if (potentialValue.charAt(0) == '(') {
					opStack.push(potentialValue.charAt(0));
				}
				//If it is a right parentheses, perform the operations until you reach a left parentheses
				else if (potentialValue.charAt(0) == ')') {
					while (opStack.top() != '(') {
						doOp();
						//If the size gets reduced to zero, then we are missing a parentheses.
						//Throw an exception
						if (opStack.size() == 0) {
							lineInput.close();
							expression.close();
							throw new IllegalArgumentException("Missing Left Parentheses.");
						}
					}
					opStack.pop();//Pop the left parentheses off when finished
				}
				
				//If the length is one, check if it is a number
				else if (potentialValue.length() == 1) {
					//If it is, then push it onto the value stack
					if (isNumber(potentialValue)) {
						valStack.push(Double.valueOf(potentialValue));
					}
					//Otherwise, use repeatOps and push the operator onto the stack
					else {
						repeatOps(potentialValue.charAt(0));
						opStack.push(potentialValue.charAt(0));
					}
				}
				//Otherwise, it is safe to assume it is a value; push it onto the value stack
				else {
					valStack.push(Double.valueOf(potentialValue));
				}
				
			}
			
			/*
			 * At this point, test if the input is correct by checking the size of the stacks
			 * A valid expression will have the value stack one bigger than the operand stack
			 * If the difference is not one, throw an exception. We then have too many
			 * or too few operators, or be missing a right parentheses.
			 */
			if (valStack.size() - opStack.size() != 1) {
				//Check if the size of the stacks are equal
				//If so, then we do not have enough values
				if (valStack.size() == opStack.size()) {
					lineInput.close();
					expression.close();
					throw new IllegalArgumentException("Too Many Operators.");
				}
				else {
				//Try to reduce the stack. If it returns null, then we ran out of operators
				try {
				repeatOps('$');
				} catch (Exception NullPointerException) {
					lineInput.close();
					expression.close();
					throw new IllegalArgumentException("Not Enough Operators.");
				}
				//Otherwise, we are missing a right parentheses
				lineInput.close();
				expression.close();
				throw new IllegalArgumentException("Missing Right Parentheses.");
				}
			}
			//Otherwise, the input will be correct, and we can reduce the stack with repeatOps()
			else {
				repeatOps('$');
			}
			
			//At this point, we can print the calculation, which will be the only value on the stack
			//By popping this value, we initialize the stack back to zero
			System.out.println("Calculation: " + valStack.pop());
			
			//If the user doesn't want to continue, then set quit to true,
			// close the input scanners, and exit the loop
			System.out.println("\n(E)valuate another or (Q)uit: ");
			String quitInput = lineInput.next();
			if (quitInput.charAt(0) == 'Q' || quitInput.charAt(0) == 'q') {
				expression.close();
				lineInput.close();
				quit = true;
			}
		} while(!quit);	
		return;
		
	}
	
	//call this method from evalInfix()
	/**
	 * This method will determine if the string passed to it is an operator or a number
	 * @param op the string to be test if it is an number
	 * @return True if op is a number
	 */
	private static boolean isNumber(String op) {
		/*
		 * Created by: Codename: Guitar
		 * On: 3/6/20
		 * CPSC 3200
		 */
		String operands = "+-*/^";//Possible operands
		boolean isNumber = true;//Will be set based on whether or not op is an operator
		//Travel the operands string and compare it
		for (int i = 0; i < operands.length() && isNumber;i++) {
			//If the are equal, then it is a match. Set the isNumber variable to false
			if (operands.charAt(i) == op.charAt(0)) {
				isNumber = false;
			}
			else
				continue;
		}
		//At this point, we can just return the value of isOperator
		return isNumber;
	}
	
	//call this method from evalInfix()
	private static void repeatOps(char refOp) {
		while(valStack.size() > 1 && 
				(prec(refOp) <= prec(opStack.top()))) {
			doOp();
		}
	}
	
	//call this method from evalInfix() 
	private static void doOp() {
		/*
		 * Created by: Codename: Guitar
		 * On: 3/6/20
		 * CPSC 3200
		 */
		//Assign values to use for the operation
		//Format is y op x
		double x = valStack.pop();
		double y = valStack.pop();
		char op = opStack.pop();
		
		//Switch through the available operators, and perform the operation
		//No need to test for a default case here. Everything will be acceptable input
		switch (op) {
		case '+': valStack.push(y+x);break;
		case '-': valStack.push(y-x);break;
		case '*': valStack.push(y*x);break;
		case '/': valStack.push(y/x);break;
		case '^': valStack.push(Math.pow(y, x));
		}
		return;
	}
	
	// possible usage for method below
	//method to return precedence of operators ... 
	//
	// ^ : 3
	// *,/ : 2
	// +,- : 1
	// $ : -1
	// call this method from evalInfix()
	public static int prec(char refOp) {
		/*
		 * Created by: Codename: Guitar
		 * On: 3/6/20
		 * CPSC 3200
		 */
		//Switch between the different operands, and return a number for the precedence
		switch (refOp) {
		case '^': return 3;
		case '*': return 2;
		case '/': return 2;
		case '+': return 1;
		case '-': return 1;
		default: return -1;//Will be used for the '$' token
		}
	}
}
