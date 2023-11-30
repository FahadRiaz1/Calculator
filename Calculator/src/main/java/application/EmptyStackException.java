package application;

/**
 * Signals that an operation was attempted on an empty stack. Exception thrown to indicate that
 * stack does not contain any entries.
 * 
 * @author Fahad Riaz
 * 
 */
public class EmptyStackException extends Exception {

  // This line was automatically added after autofix due to checkstyle error.
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new EmptyStackException with the specified detail message.
   * 
   * @param message The detail message
   */
  public EmptyStackException(String message) {
    super(message);
  }

}
