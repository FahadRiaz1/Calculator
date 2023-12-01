package application;

public class RevPolishCalc {
  
  private NumStack numStack;
  
  public RevPolishCalc() {
    numStack = new NumStack();
  }
  
  
  
  public float evaluate(String rpnExpression)throws InvalidExpression, EmptyStackException, BadTypeException {
    String[] tokens = rpnExpression.split("\\s+");
    
    for (String token : tokens) {
      if (isNumber(token)) {
        numStack.push(Float.parseFloat(token));
      } else {
        float answer = applyOperation(token);
        numStack.push(answer);
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
  
  
  public float applyOperation(String token) throws EmptyStackException, BadTypeException {
    
    float operand2 = numStack.pop();
    float operand1 = numStack.pop();
    
    switch (token) {
      case "+":
        return operand1 + operand2;
        
      default:
        throw new IllegalArgumentException("Invalid operator: " + token);
    }

  }

}
