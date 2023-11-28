package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {
  
  private NumStack numStack;
  
  @BeforeEach
  public void setUp() {
    numStack = new NumStack();
  }


  @Test
  public void testNumStackClassObjectCreation() {
    numStack = new NumStack();
    assertNotNull(numStack);

  }

  @Test
  public void numStackShouldHaveSizeZeroUponInitialization() {
    assertEquals(0, numStack.size());

  }
  
  @Test
  public void numStackSizeShouldIncreaseByOneAfterSinglePush() {
    numStack.push(5.5f);
    assertEquals(1, numStack.size());

  }
  
  @Test
  public void numStackSizeShouldIncreaseByTwoAfterTwoPushes() {

    numStack.push(10f);
    numStack.push(55.5f);

    assertEquals(2, numStack.size());
  }
  
  

}
