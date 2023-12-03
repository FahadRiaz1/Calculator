package application;

import java.util.function.Consumer;
import java.util.function.Function;

public class MockView implements ViewInterface {
  private String expression;
  private String answer;
  private Runnable calculateObserver;
  private Consumer<OpType> typeObserver;

  @Override
  public void addCalculateObserver(Runnable f) {
    this.calculateObserver = f;
  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    this.typeObserver = c;
  }

  @Override
  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  @Override
  public void setAnswer(String a) {
    this.answer = a;
  }

  public String getAnswer() {
    return answer;
  }

  @Override
  public void startView() {

  }


  public void triggerCalculate() {
    if (calculateObserver != null) {
      calculateObserver.run();
    }
  }

  public void triggerTypeChange(OpType type) {
    if (typeObserver != null) {
      typeObserver.accept(type);
    }
  }
}
