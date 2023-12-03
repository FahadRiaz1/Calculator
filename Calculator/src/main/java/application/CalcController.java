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
      float result = myModel.evaluate(expression, isInfix);
      myView.setAnswer(String.valueOf(result));
    } catch (Exception e) {
      myView.setAnswer("Error:  " + e.getMessage());
    }
  }

  private void handleTypeChange() {}

  CalcController(CalcModel model, ViewInterface view) {
    this.myModel = model;
    this.myView = view;


    this.myView.addCalculateObserver(this::handleCalculation);
  }
}
