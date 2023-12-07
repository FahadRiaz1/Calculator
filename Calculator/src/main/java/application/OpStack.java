package application;


/**
 * Represents a op/symbol stack that stores Symbol enum values.
 * 
 * <p>This class provides standard stack operations for symbol values like push, pop, top and size.
 * 
 * @author Fahad Riaz
 */
public class OpStack {

  private Stack stack;

  /**
   * Initialises a new empty opstack.
   * 
   */
  public OpStack() {
    this.stack = new Stack();
  }

  /**
   * Returns the number of entries in the opstack.
   * 
   * @return the size of the opstack
   */
  public int size() {
    return stack.size();
  }

  /**
   * Pushes a new symbol into the opstack.
   * 
   * @param symbol the symbol to be pushed onto the opstack
   */
  public void push(Symbol symbol) {
    stack.push(new Entry(symbol));

  }

  /**
   * Pops the top symbol off the opstack.
   * 
   * @return the popped symbol
   * @throws EmptyStackException if the opstack is empty
   * @throws BadTypeException if the opstack has a bad type
   */
  public Symbol pop() throws EmptyStackException, BadTypeException {
    Entry entry = stack.pop();
    return entry.getSymbol();

  }

  /**
   * Retrieves the top symbol value of the opstack.
   * 
   * @return the top symbol of opstack
   * @throws BadTypeException if the opstack has a bad type
   * @throws EmptyStackException if the opstack is empty
   */
  public Symbol top() throws BadTypeException, EmptyStackException {
    Entry entry = stack.top();
    return entry.getSymbol();
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

}
