package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EnumsTest {

  @Test // Test 1
  // Created toString method and constructor for Symbol to make this test pass.
  public void testIsSymbolEnumPrintable() {
    Symbol testSymbolOne = Symbol.PLUS;
    assertEquals("+", testSymbolOne.toString());

    Symbol testSymbolTwo = Symbol.LEFT_BRACKET;
    assertEquals("(", testSymbolTwo.toString());
  }

  @Test // Test 2
  // Created toString method and constructor for Type to make this test pass.
  public void testIsTypeEnumPrintable() {
    Type testType = Type.SYMBOL;
    assertEquals("Symbol", testType.toString());
  }

}
