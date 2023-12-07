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
  public void opStackSizeShouldDecreaseByOneAfterPopAndPopShouldReturnThePushedSymbol()
      throws EmptyStackException, BadTypeException {
    opStack.push(Symbol.MINUS);
    assertEquals(1, opStack.size());

    Symbol poppedSymbol = opStack.pop();
    assertEquals(0, opStack.size());
    assertEquals(Symbol.MINUS, poppedSymbol);
  }

  @Test
  public void popShouldReturnAndRemoveTopEntry() throws EmptyStackException, BadTypeException {
    opStack.push(Symbol.DIVIDE);
    assertEquals(1, opStack.size());

    opStack.push(Symbol.LEFT_BRACKET);
    assertEquals(2, opStack.size());

    Symbol topSymbol = opStack.pop();
    assertEquals(1, opStack.size());
    assertEquals(Symbol.LEFT_BRACKET, topSymbol);
  }

  @Test
  public void testPopMethodOnEmptyOpStack() {
    assertEquals(0, opStack.size());
    assertThrows(EmptyStackException.class, () -> {
      opStack.pop();
    });
  }

  @Test
  public void topShouldReturnTopEntryWithoutRemovingIt()
      throws EmptyStackException, BadTypeException {
    opStack.push(Symbol.DIVIDE);
    opStack.push(Symbol.RIGHT_BRACKET);

    Symbol topValue = opStack.top();
    assertEquals(Symbol.RIGHT_BRACKET, topValue);
    assertEquals(2, opStack.size());

  }

  @Test
  public void testTopMethodOnEmptyOpStack() {
    assertEquals(0, opStack.size());
    assertThrows(EmptyStackException.class, () -> {
      opStack.top();
    });

  }

  @Test
  public void opStackShouldHandleManyPushesAndPopsSuccessfully()
      throws EmptyStackException, BadTypeException {
    final int totalEntries = 10000;

    for (int i = 0; i < totalEntries; i++) {
      opStack.push(Symbol.PLUS);
    }
    assertEquals(totalEntries, opStack.size());

    for (int i = 0; i < totalEntries; i++) {
      opStack.pop();
    }
    assertEquals(0, opStack.size());
  }



}
