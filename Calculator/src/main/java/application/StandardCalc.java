package application;

public class StandardCalc {

  private NumStack numStack;
  private OpStack opStack;
  private RevPolishCalc rpCalc;

  public StandardCalc() {
    numStack = new NumStack();
    opStack = new OpStack();
    rpCalc = new RevPolishCalc();
  }

  public float evaluate(String infixExpression)
      throws InvalidExpression, EmptyStackException, BadTypeException {

    String postfixExpression = convertToRPN(infixExpression);

    return rpCalc.evaluate(postfixExpression);

  }

}
