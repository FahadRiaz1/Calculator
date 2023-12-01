package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {

  private RevPolishCalc rpnCalc;

  @BeforeEach
  public void setUp() {
    rpnCalc = new RevPolishCalc();
  }

  @Test
  public void testRevPolishCalcClassObjectCreation() {
    rpnCalc = new RevPolishCalc();
    assertNotNull(rpnCalc);

  }

  @Test
  public void testSimpleAddition() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(11.0f, rpnCalc.evaluate("5 6 +"));

  }

  @Test
  public void testSimpleSubtraction()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(1.0f, rpnCalc.evaluate("6 5 -"));

  }

  @Test
  public void testSimpleMultiplication()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(25.0f, rpnCalc.evaluate("5 5 *"));

  }

  @Test
  public void testSimpleDivision() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(7.0f, rpnCalc.evaluate("35 5 /"));

  }

  @Test
  public void testDivisionByZero() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertThrows(IllegalArgumentException.class, () -> rpnCalc.evaluate("4 0 /"));

  }

  @Test
  public void testSingleNumber() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(2f, rpnCalc.evaluate("2"));

  }

  @Test
  public void testComplexRpnExpression()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(63f, rpnCalc.evaluate("5 6 7 + * 2 -"));

  }

  @Test
  public void testComplexRpnExpressionOneMoreTimeWithDifferentExample()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(2f, rpnCalc.evaluate("3 4 + 2 * 7 /"));

  }

  @Test
  public void testEvaluateMethodOnEmptyOrNullExpression()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    assertThrows(InvalidExpression.class, () -> {
      rpnCalc.evaluate("");
      rpnCalc.evaluate(null);
    });

  }

  @Test
  public void testEvaluateMethodOnInvalidToken()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    assertThrows(InvalidExpression.class, () -> {
      rpnCalc.evaluate("5 2 $");

    });

  }

  @Test
  public void testEvaluateOnInsufficientOperands()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    assertThrows(InvalidExpression.class, () -> {
      rpnCalc.evaluate("5 +");

    });

  }

}
