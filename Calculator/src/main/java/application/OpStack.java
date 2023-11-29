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

}
