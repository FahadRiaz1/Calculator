package application;

/**
 * Represents a string stack that stores string values.
 * 
 * <p>This class provides standard stack operations for string values like push, pop, top and size.
 * 
 * @author Fahad Riaz
 */
public class StrStack {
  
  private Stack stack;
  
  /**
   * Initialises a new empty strStack.
   * 
   */
  public StrStack() {
    this.stack = new Stack();
  }
  
  /**
   * Returns the number of entries in the strStack.
   * 
   * @return the size of the strStack
   */
  public int size() {
    return stack.size();
  }
  
  /**
   * Pushes a new string into the strStack.
   * 
   * @param string the string to be pushed onto the strStack
   */
  public void push(String string) {
    stack.push(new Entry(string));
    
  }
  
  /**
   * Pops the top string value off the strStack.
   * 
   * @return the popped string
   * @throws EmptyStackException if the strStack is empty
   * @throws BadTypeException if the strStack has a bad type
   */
  public String pop() throws EmptyStackException, BadTypeException {
    Entry entry = stack.pop();
    return entry.getString();
    
  }
  
  /**
   * Retrieves the top string value of the strStack.
   * @return the top string of strStack
   * @throws BadTypeException if the strStack has a bad type
   * @throws EmptyStackException if the strStack is empty
   */
  public String top() throws BadTypeException, EmptyStackException {
    Entry entry = stack.top();
    return entry.getString();
  }

}
