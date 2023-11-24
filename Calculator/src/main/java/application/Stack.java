package application;

import java.util.ArrayList;

/**
 * Represents a stack that stores entries.
 * 
 * <p>This class provides standard stack operations like push, pop, top and size.
 * 
 * @author Fahad Riaz
 * 
 */
public class Stack {
  private int size;
  private ArrayList<Entry> entries;

  /**
   * Initialises a new empty stack.
   */
  public Stack() {
    this.entries = new ArrayList<>();
    this.size = 0;
  }

  /**
   * Returns the number of entries in the stack.
   * 
   * @return the size of the stack
   */
  public int size() {
    return size;

  }

  /**
   * Pushes a new entry onto the stack.
   * 
   * @param entry the entry to be pushed onto the stack
   */
  public void push(Entry entry) {
    entries.add(entry);
    this.size = size + 1;


  }

  /**
   * Pops the top entry off the stack.
   * 
   * @return the popped entry
   * @throws EmptyStackException if the stack is empty
   */
  public Entry pop() throws EmptyStackException {
    if (entries.isEmpty()) {
      throw new EmptyStackException("The stack is empty. ");
    }
    Entry topEntry = entries.get(entries.size() - 1);
    entries.remove(entries.size() - 1);
    this.size = size - 1;
    return topEntry;


  }

  /**
   * Retrieves, but does not remove, the top entry of the stack.
   * 
   * @return the top entry of the stack
   * @throws EmptyStackException if the stack is empty
   */
  public Entry top() throws EmptyStackException {
    if (entries.isEmpty()) {
      throw new EmptyStackException("The stack is empty. ");
    }
    Entry topEntry = entries.get(entries.size() - 1);
    return topEntry;


  }

}
