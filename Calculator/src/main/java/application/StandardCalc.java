package application;

public class StandardCalc {

  private OpStack opStack;
  private RevPolishCalc rpCalc;

  public StandardCalc() {
    opStack = new OpStack();
    rpCalc = new RevPolishCalc();
  }

  public float evaluate(String infixExpression)
      throws InvalidExpression, EmptyStackException, BadTypeException {

    String postfixExpression = convertToRPN(infixExpression);

    return rpCalc.evaluate(postfixExpression);

  }

  public String convertToRPN(String infix)
      throws InvalidExpression, EmptyStackException, BadTypeException {

    StringBuilder rpnExpression = new StringBuilder();

    for (int i = 0; i < infix.length(); i++) {
      char token = infix.charAt(i);

      if (Character.isWhitespace(token))
        continue;

      if (Character.isDigit(token)) {

        while (i < infix.length()
            && (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {

          rpnExpression.append(infix.charAt(i++));
        }
        rpnExpression.append(' ');
        i--;

      } else {

        Symbol symbol = getSymbol(token);
        if (symbol == Symbol.LEFT_BRACKET) {
          opStack.push(symbol);
        } else if (symbol == Symbol.RIGHT_BRACKET) {

          while (!opStack.isEmpty() && opStack.top() != Symbol.LEFT_BRACKET) {
            rpnExpression.append(opStack.pop().toString()).append(' ');

          }
          if (opStack.isEmpty()) {
            throw new InvalidExpression("Mismatched brackets. ");
          }
          opStack.pop();
        } else if (symbol != Symbol.INVALID) {
          while (!opStack.isEmpty() && hasHigherPrecedence(opStack.top(), symbol)) {
            rpnExpression.append(opStack.pop().toString()).append(' ');
          }
          opStack.push(symbol);
        } else {
          throw new InvalidExpression("Invalid character found:  " + token);
        }
      }
    }

    while (!opStack.isEmpty()) {
      if (opStack.top() == Symbol.LEFT_BRACKET) {
        throw new InvalidExpression("Mismatched brackets. ");
      }
      rpnExpression.append(opStack.pop().toString()).append(' ');
    }

    return rpnExpression.toString().trim();

  }


  public Symbol getSymbol(char token) {
    for (Symbol s : Symbol.values()) {
      if (s.toString().equals(String.valueOf(token))) {
        return s;
      }
    }
    return Symbol.INVALID;
  }


  public boolean hasHigherPrecedence(Symbol op1, Symbol op2) {
    if (op1 == Symbol.LEFT_BRACKET || op1 == Symbol.RIGHT_BRACKET)
      return false;
    if ((op1 == Symbol.MULTIPLY || op1 == Symbol.DIVIDE)
        && (op2 == Symbol.PLUS || op2 == Symbol.MINUS))
      return true;

    return false;

  }

}
