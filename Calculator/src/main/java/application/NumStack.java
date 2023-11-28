package application;

/**
 * Represents a numeric stack that stores float values.
 * 
 * <p>This class provides standard stack operations for numeric values like push, pop, top and size.
 * 
 * @author Fahad Riaz
 */
public class NumStack {
  
  private Stack stack;
  
  /**
   * Initialises a new empty numeric stack.
   * 
   */
  public NumStack() {
    this.stack = new Stack();
  }
  
  /**
   * Returns the number of entries in the numeric stack.
   * 
   * @return the size of the numeric stack
   */
  public int size() {
    return stack.size();
  }
  
  /**
   * Pushes a new float into the numeric stack.
   * 
   * @param number the float to be pushed onto the numeric stack
   */
  public void push(float number) {
    stack.push(new Entry(number));
    
  }
  
  /**
   * Pops the top float off the numeric stack.
   * 
   * @return the popped float
   * @throws EmptyStackException if the numeric stack is empty
   * @throws BadTypeException if the numeric stack has a bad type
   */
  public float pop() throws EmptyStackException, BadTypeException {
    Entry entry = stack.pop();
    return entry.getNumber();
    
  }
  
  /**
   * Retrieves the top float value of the numeric stack.
   * @return the top float of numeric stack
   * @throws BadTypeException if the numeric stack has a bad type
   * @throws EmptyStackException if the numeric stack is empty
   */
  public float top() throws BadTypeException, EmptyStackException {
    Entry entry = stack.top();
    return entry.getNumber();
  }

}
