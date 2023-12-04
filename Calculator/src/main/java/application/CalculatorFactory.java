package application;

public class CalculatorFactory {

  public static Calculator createCalculator(boolean isInfix) {
    if (isInfix) {
      return new StandardCalc();
    } else {
      return new RevPolishCalc();
    }
  }


}
