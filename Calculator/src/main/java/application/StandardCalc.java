package application;

public class StandardCalc {

  private NumStack numStack;
  private OpStack opStack;
  private RevPolishCalc rpCalc;

  public StandardCalc() {
    numStack = new NumStack();
    opStack = new OpStack();
    rpCalc = new RevPolishCalc();
  }

}
