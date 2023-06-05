package pages;

import base.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage extends TestBase {
  private final SelenideElement emailInput = $(byName("email"));
  private final SelenideElement nameInput = $(byName("name"));
  private final SelenideElement surnameInput = $(byName("surname"));
  private final SelenideElement passwordInput = $(byName("password"));
  private final SelenideElement passwordRepeatInput =  $(byName("password-repeat"));
  private final SelenideElement robotCheckbox =  $(byId("checkbox"));
  private final SelenideElement submitButton = $("button.btn-success");

  public RegistrationPage() {
    page(this);

  }

  public void openPage() {
    open("/registration.php");
  }

  public void enterEmail(String email) {
    emailInput.val(email);

  }

  public void enterName(String name) {
    nameInput.val(name);
  }

  public void enterSurname(String surname) {
    surnameInput.val(surname);
  }

  public void enterPassword(String password) {
    passwordInput.val(password);
  }

  public void enterPasswordRepeat(String passwordRepeat) {
    passwordRepeatInput.val(passwordRepeat);
  }

  public void checkRobotCheckbox() {
    robotCheckbox.click();
  }

  public void submitRegistration() {
    submitButton.click();
  }

  public void checkRegistrationFailed(){
    $("div.alert-danger").shouldBe(Condition.visible);
//    assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());
  }
  public void checkRegistrationSucceeded(){
    $("div.alert-success").shouldBe(Condition.visible);
//    assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
  }
}
