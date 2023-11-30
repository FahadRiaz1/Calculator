package application;

public class StrStack {
  
 private Stack stack;
  
  /**
   * Initialises a new empty strStack.
   * 
   */
  public StrStack() {
    this.stack = new Stack();
  }
  
  public int size() {
    return stack.size();
  }
  
  public void push(String string) {
    stack.push(new Entry(string));
    
  }

}
