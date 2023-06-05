package pages;

import base.TestBase;
import com.codeborne.selenide.SelenideElement;
import enumerators.BananaTableColumn;
import org.openqa.selenium.By;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.open;

public class BananaPage extends TestBase {
  private final SelenideElement submitButton = $("button");
  private final SelenideElement bananaAmountInput = $("input");
  private final SelenideElement resultTable = $("table");

  public BananaPage() {
    page(this);
  }

  public void openPage() {
    open("/bananashop.php");
  }

  public void enterBananaAmount(String bananaAmount) {
    bananaAmountInput.clear();
    bananaAmountInput.sendKeys(bananaAmount);
  }

  public String getTableValue(BananaTableColumn bananaTableColumns) {
    return resultTable.findElement(By.xpath("//tr[" + bananaTableColumns.getRowIndex() + "]/td[2]")).getText();
  }

  public void submitBananaAmount() {
    submitButton.click();
  }

  public void fakeCheck(Map<String, String> tableMap) {
    System.out.println("Web is broken");
  }
}
