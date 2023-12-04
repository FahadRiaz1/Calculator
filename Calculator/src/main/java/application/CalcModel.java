package application;

/**
 * Evaluates an expression - the evaluation can be Standard (infix) or reverse polish.
 * 
 * @author Fahad Riaz
 */
public class CalcModel implements Calculator {

  private boolean isInfix;

  /**
   * Constructs a CalcModel instance with default calculation mode set to infix.
   * 
   */
  public CalcModel() {
    isInfix = true;
  }

  /**
   * Sets the calculation mode of the model.
   * 
   * @param isInfix If true, calculator is set to infix mode, otherwise RPN mode
   */
  public void setInfix(boolean isInfix) {
    this.isInfix = isInfix;
  }

  /**
   * Evaluates the given expression based on the current calculation mode. It uses the factory to
   * create an appropriate calculator based on the infix flag and gives evaluation to it.
   *
   */
  @Override
  public float evaluate(String expression)
      throws InvalidExpression, EmptyStackException, BadTypeException {

    Calculator calculator = CalculatorFactory.createCalculator(isInfix);
    return calculator.evaluate(expression);
  }
}
