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
  
  @Test
  public void numStackSizeShouldDecreaseByOneAfterPopAndPopShouldReturnThePushedNumber() throws EmptyStackException, BadTypeException {
    numStack.push(100.567f);
    assertEquals(1, numStack.size());

    float poppedValue = numStack.pop();
    assertEquals(0, numStack.size());
    assertEquals(100.567f, poppedValue);
  }
  
  @Test
  public void popShouldReturnAndRemoveTopEntry() throws EmptyStackException, BadTypeException {
    numStack.push(5.5f);
    assertEquals(1, numStack.size());

    numStack.push(3.5f);
    assertEquals(2, numStack.size());

    float topValue = numStack.pop();
    assertEquals(1, numStack.size());
    assertEquals(3.5f, topValue);
  }
  
  @Test
  public void testPopMethodOnEmptyNumStack() {
    assertEquals(0, numStack.size());
    assertThrows(EmptyStackException.class, () -> {
      numStack.pop();
    });
  }
  
  @Test
  public void topShouldReturnTopEntryWithoutRemovingIt() throws EmptyStackException, BadTypeException {
    numStack.push(1.5f);
    numStack.push(5.3f);

    float topValue = numStack.top();
    assertEquals(5.3f, topValue);
    assertEquals(2, numStack.size());

  }
  
  @Test
  public void testTopMethodOnEmptyStack() {
    assertEquals(0, numStack.size());
    assertThrows(EmptyStackException.class, () -> {
      numStack.top();
    });

  }
  
  @Test
  public void numStackShouldHandleManyPushesAndPopsSuccessfully() throws EmptyStackException, BadTypeException {
    final int totalEntries = 10000;

    for (int i = 0; i < totalEntries; i++) {
      numStack.push(55.5f);
    }
    assertEquals(totalEntries, numStack.size());

    for (int i = 0; i < totalEntries; i++) {
      numStack.pop();
    }
    assertEquals(0, numStack.size());
  }
  

}
