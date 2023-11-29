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



}