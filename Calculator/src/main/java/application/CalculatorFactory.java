package application;

/**
 * Factory class for creating instances of different types of calculators. This class encapsulates
 * the logic for instantiating calculator objects, allowing for easy creation of instances based on
 * different calculation modes.
 * 
 * @author Fahad Riaz
 * 
 */
public class CalculatorFactory {

  /**
   * Creates and returns a Calculator instance based on the provided calculation mode.
   * 
   * @param isInfix A boolean value indicating the type of calculator to be created.
   * @return calculator instance of either StandardCalc or RevPolishCalc based on provided mode
   */
  public static Calculator createCalculator(boolean isInfix) {
    if (isInfix) {
      return new StandardCalc();
    } else {
      return new RevPolishCalc();
    }
  }


}
