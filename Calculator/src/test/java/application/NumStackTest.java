package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NumStackTest {
  
  private NumStack numStack;

  @Test
  public void testNumStackClassObjectCreation() {
    numStack = new NumStack();
    assertNotNull(numStack);

  }

}
