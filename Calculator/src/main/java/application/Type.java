package application;

/**
 * Enumerates the various data types that an Entry object can represent.
 * 
 * @author Fahad Riaz
 * 
 */
public enum Type {
  STRING("String"), NUMBER("Number"), SYMBOL("Symbol"), INVALID("Invalid");

  private final String description;

  Type(String description) {
    this.description = description;
  }

  /**
   * Prints the enum.
   *
   */
  public String toString() {
    return description;
  }

}
