package application;

import java.util.Objects;

/**
 * Represents a single entry in the stack.
 * 
 * <p>Each entry holds a value of a specific type: number, symbol, string, or invalid. The class
 * provides methods to safely retrieve these values, throwing a {@link BadTypeException} if an
 * inappropriate retrieval is attempted.
 * 
 * @author Fahad Riaz
 * 
 */
public class Entry {
  private float number;
  private Symbol symbol;
  private String str;
  private Type type;

  /**
   * Initialises the entry with a float numeric value.
   * 
   * @param value the float number value
   */
  public Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }

  /**
   * Initialises the entry with a symbol.
   * 
   * @param symbol the symbol value from enum
   */
  public Entry(Symbol symbol) {
    this.symbol = symbol;
    this.type = Type.SYMBOL;

  }

  /**
   * Initialises the entry with a string.
   * 
   * @param string string value
   */
  public Entry(String string) {
    this.str = string;
    this.type = Type.STRING;
  }

  /**
   * Initialises the entry with an invalid type and sets other fields to default values.
   */
  public Entry() {
    this.type = Type.INVALID;
    this.number = 0.0f;
    this.str = null;
    this.symbol = null;
  }

  /**
   * Retrieves the numeric value of the entry.
   * 
   * @return numeric value of entry
   * @throws BadTypeException if the entry type is not a number
   */
  public float getNumber() throws BadTypeException {
    if (this.type != Type.NUMBER) {
      throw new BadTypeException("Expected Number Type but found: " + this.type);
    }
    return number;
  }

  /**
   * Retrieves the symbol value of the entry.
   * 
   * @return symbol value of the entry
   * @throws BadTypeException if the entry type is not a symbol
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.type != Type.SYMBOL) {
      throw new BadTypeException("Expected Symbol Type but found: " + this.type);
    }
    return symbol;
  }

  /**
   * Retrieves the string value of the entry.
   * 
   * @return string value of the entry
   * @throws BadTypeException if the entry type is not a string
   */
  public String getString() throws BadTypeException {
    if (this.type != Type.STRING) {
      throw new BadTypeException("Expected String Type but found: " + this.type);
    }
    return str;
  }

  /**
   * Retrieves the type of the entry.
   * 
   * @return type of the entry
   */
  public Type getType() {
    return type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, str, symbol, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        && Objects.equals(str, other.str) && symbol == other.symbol && type == other.type;
  }



}
