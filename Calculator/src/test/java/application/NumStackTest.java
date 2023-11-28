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

}
