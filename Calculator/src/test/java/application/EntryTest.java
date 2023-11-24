package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class EntryTest {

  @Test // Test 1
  // Created the entry class, its float constructor and getters to pass this test.
  public void constructorShouldInitializeWithFloat() throws BadTypeException {
    Entry e = new Entry(3.6f);
    assertEquals(3.6f, e.getNumber());

  }

  @Test // Test 2
  // Modified this test to use enum Symbol instead of using symbols as a string.
  public void constructorShouldInitializeWithSymbol() throws BadTypeException {
    Symbol testSymbol = Symbol.MINUS;
    Entry e = new Entry(testSymbol);
    assertEquals(testSymbol, e.getSymbol());

  }

  @Test // Test 3
  public void constructorShouldInitializeWithString() throws BadTypeException {
    Entry e = new Entry("test");
    assertEquals("test", e.getString());

  }

  @Test // Test 4
  public void getTypeShouldReturnNumberForFloat() {
    Entry e = new Entry(6.9f);
    Type testType = Type.NUMBER;
    assertEquals(testType, e.getType());
  }

  @Test // Test 5
  public void getTypeShouldReturnSymbolForSymbol() {
    Entry e = new Entry(Symbol.DIVIDE);
    Type testType = Type.SYMBOL;
    assertEquals(testType, e.getType());
  }

  @Test // Test 6
  public void getTypeShouldReturnStringForString() {
    Entry e = new Entry("test");
    Type testType = Type.STRING;
    assertEquals(testType, e.getType());
  }

  @Test // Test 7
  public void getTypeShouldReturnInvalidForNoArgsConstructor() {
    Entry e = new Entry();
    Type testType = Type.INVALID;
    assertEquals(testType, e.getType());
  }

  @Test // Test 8
  public void getStringShouldThrowExceptionForNonStringType() {
    Entry e = new Entry(1.0f);
    assertThrows(BadTypeException.class, () -> {
      e.getString();
    });
  }

  @Test // Test 9
  public void getSymbolShouldThrowExceptionForNonSymbolType() {
    Entry e = new Entry("test");
    assertThrows(BadTypeException.class, () -> {
      e.getSymbol();
    });
  }

  @Test // Test 10
  public void getNumberShouldThrowExceptionForNonNumberType() {
    Entry e = new Entry("test");
    assertThrows(BadTypeException.class, () -> {
      e.getNumber();
    });

  }

  @Test // Test 11
  public void objectShouldBeEqualToItself() {
    Entry e = new Entry("test");
    assertTrue(e.equals(e));
  }

  @Test // Test 12
  public void twoSimilarEntriesShouldBeEqual() {
    Entry entryOne = new Entry(Symbol.DIVIDE);
    Entry entryTwo = new Entry(Symbol.DIVIDE);

    assertTrue(entryOne.equals(entryTwo));
    assertTrue(entryTwo.equals(entryOne));

  }

  @Test // Test 13
  public void twoDifferentStringEntriesShouldNotBeEqual() {
    Entry entryOne = new Entry("test");
    Entry entryTwo = new Entry("sa");

    assertFalse(entryOne.equals(entryTwo));
    assertFalse(entryTwo.equals(entryOne));
  }

  @Test // Test 14
  public void twoEntriesWithSameValueButDifferentTypeShouldNotBeEqual() {
    Entry entryOne = new Entry(Symbol.MINUS);
    Entry entryTwo = new Entry("MINUS");

    assertFalse(entryOne.equals(entryTwo));
    assertFalse(entryTwo.equals(entryOne));

  }

  @Test // Test 15
  public void objectShouldNotBeEqualToNull() {
    Entry e = new Entry(2.0f);
    assertFalse(e.equals(null));
  }

  @Test // Test 16
  public void equalObjectsShouldHaveSameHashCode() {
    Entry entryOne = new Entry(3f);
    Entry entryTwo = new Entry(3f);

    assertEquals(entryOne.hashCode(), entryTwo.hashCode());
  }

  @Test // Test 17
  public void differentObjectsShouldHaveDifferentHashCode() {
    Entry entryOne = new Entry("hello");
    Entry entryTwo = new Entry("hi");

    assertNotEquals(entryOne.hashCode(), entryTwo.hashCode());

  }

  @Test // Test 18
  public void entryShouldNotBeEqualToDifferentClassObject() {
    Entry e = new Entry(1.0f);
    assertFalse(e.equals("A random string, not an object"));
  }

  @Test // Test 19
  public void twoDifferentNumberEntriesShouldNotBeEqual() {
    Entry entryOne = new Entry(1.5f);
    Entry entryTwo = new Entry(2.5f);

    assertFalse(entryOne.equals(entryTwo));
    assertFalse(entryTwo.equals(entryOne));
  }



}
