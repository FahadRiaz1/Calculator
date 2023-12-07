package application;

/**
 * An expression was passed to a method that could not be evaluated.
 * 
 * @author Fahad Riaz
 */

public class InvalidExpression extends Exception {
  // This line was automatically added after autofix due to checkstyle error.
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new InvalidExpression exception with the specified detail message.
   * 
   * @param message The detail message
   */
  public InvalidExpression(String message) {
    super(message);
  }

}
