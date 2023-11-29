package application;

public class OpStack {
  
  private Stack stack;
  
  public OpStack() {
    this.stack = new Stack();
  }
  
  public int size() {
    return stack.size();
  }
  
  public void push(Symbol symbol) {
    stack.push(new Entry(symbol));
    
  }
  
  public Symbol pop() throws EmptyStackException, BadTypeException {
    Entry entry = stack.pop();
    return entry.getSymbol();
    
  }
  
  public Symbol top() throws BadTypeException, EmptyStackException {
    Entry entry = stack.top();
    return entry.getSymbol();
  }

}
