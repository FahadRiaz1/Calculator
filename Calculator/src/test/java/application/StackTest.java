package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

  // I completed the Entry, Symbol and Type classes before the whole Stack Test and implementation.

  private Stack stack;

  @BeforeEach
  public void setUp() {
    stack = new Stack();
  }


  @Test // Test 1
  // Created the Stack class and its object to pass this test.
  public void testStackClassObjectCreation() {
    assertNotNull(stack);

  }

  @Test // Test 2
  // To pass this test:
  // Created Stack constructor with size defaulting to zero and created size method to return size.
  public void stackShouldHaveSizeZeroUponInitialization() {
    assertEquals(0, stack.size());

  }

  @Test // Test 3
  // To pass this test:
  // Created an ArrayList to store entries and created the push method.
  public void stackSizeShouldIncreaseByOneAfterSinglePush() {
    Entry testEntry = new Entry(3.5f);
    stack.push(testEntry);
    assertEquals(1, stack.size());

  }

  @Test // Test 4
  // Checked that the stack size becomes two after pushing two entries to pass this test.
  public void stackSizeShouldIncreaseByTwoAfterTwoPushes() {
    Entry testEntryOne = new Entry("test");
    Entry testEntryTwo = new Entry(Symbol.MINUS);

    stack.push(testEntryOne);
    stack.push(testEntryTwo);

    assertEquals(2, stack.size());
  }

  @Test // Test 5
  // To pass this test:
  // Created the pop method which returns the top entry and removes it from the stack.
  public void stackSizeShouldDecreaseByOneAfterPop() throws EmptyStackException {
    Entry testEntry = new Entry(2f);
    stack.push(testEntry);
    assertEquals(1, stack.size());

    stack.pop();
    assertEquals(0, stack.size());
  }

  @Test // Test 6
  public void popShouldReturnAndRemoveTopEntry() throws EmptyStackException {
    Entry testEntryOne = new Entry(Symbol.PLUS);
    stack.push(testEntryOne);
    assertEquals(1, stack.size());

    Entry testEntryTwo = new Entry(Symbol.MINUS);
    stack.push(testEntryTwo);
    assertEquals(2, stack.size());

    Entry topEntry = stack.pop();
    assertEquals(1, stack.size());
    assertEquals(testEntryTwo, topEntry);


  }

  @Test // Test 7
  // To pass this test:
  // Created the custom EmptyStackException then implemented it in the pop method.
  public void testPopMethodOnEmptyStack() {
    assertEquals(0, stack.size());
    assertThrows(EmptyStackException.class, () -> {
      stack.pop();
    });
  }

  @Test // Test 8
  // Created the top method to pass this test.
  public void topShouldReturnTopEntryWithoutRemovingIt() throws EmptyStackException {
    Entry testEntryOne = new Entry(1f);
    Entry testEntryTwo = new Entry(2f);

    stack.push(testEntryOne);
    stack.push(testEntryTwo);

    Entry topEntry = stack.top();
    assertEquals(testEntryTwo, topEntry);


  }

  @Test // Test 9
  // Implemented the EmptyStackException in the top method to pass this test.
  public void testTopMethodOnEmptyStack() {
    assertEquals(0, stack.size());
    assertThrows(EmptyStackException.class, () -> {
      stack.top();
    });

  }

  @Test // Test 10
  // Tested whether my stack can handle 10,000 entries on push and pop.
  public void stackShouldHandleManyPushesAndPopsSuccessfully() throws EmptyStackException {
    final int totalEntries = 10000;
    Entry testEntries = new Entry(5.5f);

    for (int i = 0; i < totalEntries; i++) {
      stack.push(testEntries);
    }
    assertEquals(totalEntries, stack.size());

    for (int i = 0; i < totalEntries; i++) {
      stack.pop();
    }
    assertEquals(0, stack.size());


  }

  @Test // Test 11
  // Tested whether my stack can store duplicate entries.
  public void testPushingDuplicateEntries() {
    Entry testEntry = new Entry(5.5f);
    stack.push(testEntry);
    stack.push(testEntry);

    assertEquals(2, stack.size());
  }

  @Test // Test 12
  public void testMixedEntryTypesPushAndPop() throws EmptyStackException {
    Entry floatEntry = new Entry(2.4f);
    Entry stringEntry = new Entry("testing");
    Entry symbolEntry = new Entry(Symbol.MULTIPLY);

    stack.push(floatEntry);
    stack.push(symbolEntry);
    stack.push(stringEntry);

    assertEquals(3, stack.size());

    stack.pop();
    stack.pop();
    stack.pop();

    assertEquals(0, stack.size());



  }

}
