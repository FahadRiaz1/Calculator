package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 */
public class CalcModel implements Calculator {

  private boolean isInfix;

  public CalcModel() {
    isInfix = true;
  }

  public void setInfix(boolean isInfix) {
    this.isInfix = isInfix;
  }

  @Override
  public float evaluate(String expression)
      throws InvalidExpression, EmptyStackException, BadTypeException {

    Calculator calculator = CalculatorFactory.createCalculator(isInfix);
    return calculator.evaluate(expression);
  }
}
