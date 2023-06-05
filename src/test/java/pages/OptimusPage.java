package pages;

import base.TestBase;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class OptimusPage extends TestBase {
    private final SelenideElement numberInput = $x("//input[@type='number']");
    private final SelenideElement submitButton = $("button.btn");

    public OptimusPage() {
        page(this);
    }

    public void openPage() {
        open("/primenumber.php");
    }

    public void clickOnButton() {
        submitButton.click();
    }

    public void enterNumber(String number) {
        numberInput.sendKeys(number);
    }

    public void checkResult(boolean expectedPrime) {
        if (expectedPrime) {
             $(By.xpath("//div[text()='Optimus approves']")).shouldBe(visible, Duration.ofSeconds(5));
        } else {
            $(By.xpath("//div[text()='Optimus is sad']")).shouldBe(visible, Duration.ofSeconds(5));
        }
    }
}
