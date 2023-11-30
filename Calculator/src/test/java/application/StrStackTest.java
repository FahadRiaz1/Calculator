package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {
  
private StrStack strStack;
  
  @BeforeEach
  public void setUp() {
    strStack = new StrStack();
  }


  @Test
  public void testStrStackClassObjectCreation() {
    strStack = new StrStack();
    assertNotNull(strStack);

  }
  
  @Test
  public void strStackShouldHaveSizeZeroUponInitialization() {
    assertEquals(0, strStack.size());

  }
  
  @Test
  public void strStackSizeShouldIncreaseByOneAfterSinglePush() {
    strStack.push("test");
    assertEquals(1, strStack.size());

  }

 

}
