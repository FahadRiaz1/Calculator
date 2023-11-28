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

}
