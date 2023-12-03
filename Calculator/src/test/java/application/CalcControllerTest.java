package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcControllerTest {

  private CalcModel model;
  private MockView view;
  private CalcController controller;

  @BeforeEach
  void setUp() {
    model = new CalcModel();
    view = new MockView();
    controller = new CalcController(model, view);

  }

  @Test
  public void testHandleCalculationMethod() {

    String testExpression = "2 + 2";
    view.setExpression(testExpression);


    view.triggerCalculate();

    String answer = view.getAnswer();
    assertNotNull(answer);

  }

  @Test
  public void testHandleTypeChangeMethod() {

    view.triggerTypeChange(OpType.STANDARD);
    assertTrue(controller.isInfix());

    view.triggerTypeChange(OpType.REV_POLISH);
    assertFalse(controller.isInfix());

  }

}
