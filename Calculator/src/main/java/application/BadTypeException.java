package application;

/**
 * Exception thrown when an attempt is made to access an item of incorrect type.
 * 
 * @author Fahad Riaz
 * 
 * 
 */
public class BadTypeException extends Exception {
  // This line was automatically added after autofix due to checkstyle error.
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new BadTypeException with the specified detail message.
   * 
   * @param message The detail message
   */
  public BadTypeException(String message) {
    super(message);
  }


}
