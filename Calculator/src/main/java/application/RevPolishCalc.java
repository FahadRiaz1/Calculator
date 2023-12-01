package application;

public class RevPolishCalc {
  
  private NumStack numStack;
  
  public RevPolishCalc() {
    numStack = new NumStack();
  }
  
  
  
  public float evaluate(String rpnExpression)throws InvalidExpression, EmptyStackException, BadTypeException {
    
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
  
  
  public boolean isNumber(String token) {
    try {
      Float.parseFloat(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
  
  public boolean isOperator(String token) {
    
    return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    
  }
  
  
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
