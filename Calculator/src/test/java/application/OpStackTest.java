package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {
  
private OpStack opStack;
  
  @BeforeEach
  public void setUp() {
    opStack = new OpStack();
  }


  @Test
  public void testOpStackClassObjectCreation() {
    opStack = new OpStack();
    assertNotNull(opStack);

  }
  
  @Test
  public void opStackShouldHaveSizeZeroUponInitialization() {
    assertEquals(0, opStack.size());

  }
  
  @Test
  public void opStackSizeShouldIncreaseByOneAfterSinglePush() {
    opStack.push(Symbol.PLUS);
    assertEquals(1, opStack.size());

  }
  
  @Test
  public void opStackSizeShouldIncreaseByTwoAfterTwoPushes() {

    opStack.push(Symbol.DIVIDE);
    opStack.push(Symbol.MULTIPLY);

    assertEquals(2, opStack.size());
  }
  
  @Test
  public void opStackSizeShouldDecreaseByOneAfterPopAndPopShouldReturnThePushedSymbol() throws EmptyStackException, BadTypeException {
    opStack.push(Symbol.MINUS);
    assertEquals(1, opStack.size());

    Symbol poppedSymbol = opStack.pop();
    assertEquals(0, opStack.size());
    assertEquals(Symbol.MINUS, poppedSymbol);
  }



}
