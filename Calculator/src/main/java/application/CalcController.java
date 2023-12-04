package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 * 
 * @author Fahad Riaz
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private boolean isInfix = true;

  /**
   * Handles the calculation request from the view. It retrieves the expression from the view,
   * processes it based on current mode (RPN or infix), and updates view with the result or error
   * message.
   * 
   */
  private void handleCalculation() {
    try {
      String expression = myView.getExpression();
      myModel.setInfix(isInfix);
      float result = myModel.evaluate(expression);

      myView.setAnswer(String.valueOf(result));

    } catch (InvalidExpression | EmptyStackException | BadTypeException
        | IllegalArgumentException e) {
      myView.setAnswer("Error:  " + e.getMessage());
    }
  }

  /**
   * Handles changes in the calculation type. It updates the internal state to reflect the new
   * calculation mode based on the user's selection.
   * 
   * @param opType The operation type indicating the calculation mode
   */
  private void handleTypeChange(OpType opType) {
    isInfix = (opType == OpType.STANDARD);
  }

  /**
   * Checks if the current calculation mode is infix.
   * 
   * @return true if the mode is infix, false if it is RPN
   */
  public boolean isInfix() {
    return isInfix;
  }

  /**
   * Constructs a controller with the given model and view. It registers itself as an observer to
   * the view's calculate and type change events
   * 
   * @param model the model used for performing evaluations
   * @param view the GUI
   */
  CalcController(CalcModel model, ViewInterface view) {
    this.myModel = model;
    this.myView = view;


    this.myView.addCalculateObserver(this::handleCalculation);
    this.myView.addTypeObserver(this::handleTypeChange);
  }
}
