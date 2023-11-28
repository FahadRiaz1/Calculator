package application;

public class NumStack {
  
  private Stack stack;
  
  public NumStack() {
    this.stack = new Stack();
  }
  
  public int size() {
    return stack.size();
  }
  
  public void push(float number) {
    stack.push(new Entry(number));
    
  }
  
  public float pop() throws EmptyStackException, BadTypeException {
    Entry entry = stack.pop();
    return entry.getNumber();
    
  }
  
  public float top() throws BadTypeException, EmptyStackException {
    Entry entry = stack.top();
    return entry.getNumber();
  }

}
