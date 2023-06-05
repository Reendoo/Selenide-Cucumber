package tests;

import static org.junit.Assert.assertEquals;



import base.TestBase;
import enumerators.BananaTableColumn;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.BananaPage;

public class BananaTest extends TestBase {

  @Test
  @Disabled
  public void testDiscount() {
    BananaPage bananaPage = new BananaPage();
    bananaPage.openPage();
    bananaPage.enterBananaAmount("11");
    bananaPage.submitBananaAmount();
    assertEquals("1.65 €", bananaPage.getTableValue(BananaTableColumn.DISCOUNT));
  }
}
