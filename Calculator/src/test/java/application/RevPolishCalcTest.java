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
  public void testSimpleSubtraction() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(1.0f, rpnCalc.evaluate("6 5 -"));

  }
  
  @Test
  public void testSimpleMultiplication() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(25.0f, rpnCalc.evaluate("5 5 *"));

  }
  
  @Test
  public void testSimpleDivision() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(7.0f, rpnCalc.evaluate("35 5 /"));

  }

}
