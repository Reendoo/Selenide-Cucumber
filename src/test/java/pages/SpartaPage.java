package pages;

import base.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import models.Sin;
import java.time.Duration;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
public class SpartaPage extends TestBase {
    public SpartaPage() {
        page(this);
    }

    public void openPage() {
        open("/sparta.php");
    }

    private SelenideElement getMainSinElement(Sin sin) {
        return $x("//article[p[text()='" + sin.getMessage() + "']]");
    }

    public void forgiveSin(Sin sin) {
        SelenideElement article = getMainSinElement(sin);
        article.find("button").click();
        Condition clickable = Condition.and("can be clicked", visible, enabled);
        $(byId("confirm")).shouldBe(clickable, Duration.ofSeconds(10))
                .click();
        sin.setForgiven(true);
    }
}
