package application;

public class OpStack {
  
  private Stack stack;
  
  public OpStack() {
    this.stack = new Stack();
  }
  
  public int size() {
    return stack.size();
  }

}
