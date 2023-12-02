package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardCalcTest {

  private StandardCalc standardCalc;

  @BeforeEach
  public void setUp() {
    standardCalc = new StandardCalc();
  }

  @Test
  public void testStandardCalcClassObjectCreation() {
    assertNotNull(standardCalc);

  }

  @Test
  public void testSimpleAddition() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(11.0f, standardCalc.evaluate("5 + 6"));

  }

  @Test
  public void testSimpleSubtraction()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(1.0f, standardCalc.evaluate("6 - 5"));

  }
  
  @Test
  public void testSimpleMultiplication()
      throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(25.0f, standardCalc.evaluate("5 * 5"));

  }



}
