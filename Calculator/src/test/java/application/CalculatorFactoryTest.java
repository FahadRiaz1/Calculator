package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorFactoryTest {

  @Test
  public void testFactoryObjectCreation() {
    CalculatorFactory factory = new CalculatorFactory();
    assertNotNull(factory);
  }

  @Test
  public void testCreationOfStandardCalc() {
    Calculator calc = CalculatorFactory.createCalculator(true);
    assertTrue(calc instanceof StandardCalc);
  }

  @Test
  public void testCreationOfRevPolishCalc() {
    Calculator calc = CalculatorFactory.createCalculator(false);
    assertTrue(calc instanceof RevPolishCalc);
  }

  @Test
  public void testFunctionalityOfStandardCalc()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    Calculator calc = CalculatorFactory.createCalculator(true);
    float answer = calc.evaluate("1 + 1");
    assertEquals(2.0, answer);
  }

  @Test
  public void testFunctionalityOfRevPolishCalc()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    Calculator calc = CalculatorFactory.createCalculator(false);
    float answer = calc.evaluate("2 2 +");
    assertEquals(4.0, answer);
  }

}
