package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {
  
  private RevPolishCalc rpnCalc;
  
  @BeforeEach
  public void setUp() {
    rpnCalc = new RevPolishCalc();
  }
  
  @Test
  public void testRevPolishCalcClassObjectCreation() {
    rpnCalc = new RevPolishCalc();
    assertNotNull(rpnCalc);

  }

}