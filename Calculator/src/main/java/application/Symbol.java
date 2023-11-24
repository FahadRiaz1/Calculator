package application;

/**
 * Represents mathematical and operational symbols used in the calculator.
 * 
 * @author Fahad Riaz
 * 
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), MULTIPLY("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "Invalid");

  private final String description;

  Symbol(String description) {
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
