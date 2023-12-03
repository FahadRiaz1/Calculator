package application;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalcController {
  private CalcModel myModel;
  private ViewInterface myView;
  private boolean isInfix = true;

  private void handleCalculation() {
    try {
      String expression = myView.getExpression();
      float result;

      if (isInfix) {
        StandardCalc standardCalc = new StandardCalc();
        String rpnExpression = standardCalc.convertToRPN(expression);
        result = myModel.evaluate(rpnExpression, false);
      } else {
        result = myModel.evaluate(expression, false);
      }

      myView.setAnswer(String.valueOf(result));

    } catch (InvalidExpression | EmptyStackException | BadTypeException e) {
      myView.setAnswer("Error:  " + e.getMessage());
    }
  }

  private void handleTypeChange(OpType opType) {
    isInfix = (opType == OpType.STANDARD);
  }

  public boolean isInfix() {
    return isInfix;
  }

  CalcController(CalcModel model, ViewInterface view) {
    this.myModel = model;
    this.myView = view;


    this.myView.addCalculateObserver(this::handleCalculation);
    this.myView.addTypeObserver(this::handleTypeChange);
  }
}
