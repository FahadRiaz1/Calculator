package application;

/**
 * This class provides functionality to evaluate expressions written in Reverse Polish Notation. It
 * uses a {@link NumStack} to handle numerical float values during the evaluation process.
 * 
 * @author Fahad Riaz
 * 
 */
public class RevPolishCalc {

  private NumStack numStack;

  /**
   * Constructs a new RPN Calculator.
   * 
   */
  public RevPolishCalc() {
    numStack = new NumStack();
  }



  /**
   * Evaluates the given RPN expression.
   * 
   * @param rpnExpression The RPN expression to be evaluated.
   * @return The calculated result of the RPN expression.
   * @throws InvalidExpression If the expression is invalid (e.g., empty, null, or malformed).
   * @throws EmptyStackException If an attempt is made to pop from an empty stack.
   * @throws BadTypeException If there is a type mismatch.
   */
  public float evaluate(String rpnExpression)
      throws InvalidExpression, EmptyStackException, BadTypeException {

    if (rpnExpression == null || rpnExpression.trim().isEmpty()) {
      throw new InvalidExpression("Expression is empty or null. ");
    }


    String[] tokens = rpnExpression.split("\\s+");

    for (String token : tokens) {
      if (isNumber(token)) {
        numStack.push(Float.parseFloat(token));
      } else if (isOperator(token)) {

        if (numStack.size() < 2) {
          throw new InvalidExpression("Insufficient operands.");
        }


        float answer = applyOperation(token);
        numStack.push(answer);

      } else {
        throw new InvalidExpression("Invalid expression due to invalid operators");
      }
    }

    return numStack.pop();
  }


  /**
   * Checks if the given token is a numeric float value.
   * 
   * @param token The token to be checked.
   * @return true if the token is a number; false otherwise.
   */
  public boolean isNumber(String token) {
    try {
      Float.parseFloat(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Checks if the given token is a valid operator.
   * 
   * @param token The token to be checked.
   * @return true if the token is an operator; false otherwise.
   */
  public boolean isOperator(String token) {

    return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");

  }


  /**
   * Applies the operation represented by the operator token to the operands.
   * 
   * @param token The operator to be applied for the operation.
   * @return The result of applying the operator.
   * @throws EmptyStackException If there are not enough operands on the stack.
   * @throws BadTypeException If operands are not of the right type.
   * @throws IllegalArgumentException If the token is not a valid operator.
   */
  public float applyOperation(String token) throws EmptyStackException, BadTypeException {

    float operand2 = numStack.pop();
    float operand1 = numStack.pop();

    switch (token) {
      case "+":
        return operand1 + operand2;

      case "-":
        return operand1 - operand2;

      case "*":
        return operand1 * operand2;

      case "/":
        if (operand2 == 0) {
          throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return operand1 / operand2;

      default:
        throw new IllegalArgumentException("Invalid operator: " + token);
    }

  }

}
