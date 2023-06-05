package pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;
import java.util.List;

import base.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import enumerators.SinType;
import models.Sin;

public class SinCityPage extends TestBase {
    private final SelenideElement titleInput = $(byName("title"));

    private final SelenideElement authorInput = $(byName("author"));

    private final SelenideElement messageInput = $(byName("message"));

    private final SelenideElement confessButton = $x("//button[@type='submit']");

    private final SelenideElement sinListSection = $("div.sinsListArea");

    private final SelenideElement listOfSins = $("ul.list-of-sins");

    public SinCityPage() {
        page(this);
    }

    public void openPage() {
        open("/sincity.php");
    }

    public void fillSinInformation(Sin sin) {
        fillSinTitle(sin.getTitle());
        fillSinAuthor(sin.getAuthor());
        fillSinMessage(sin.getMessage());
    }

    public void fillSinTitle(String title) {
        titleInput.sendKeys(title);
    }

    public void fillSinAuthor(String author) {
        authorInput.sendKeys(author);
    }

    public void fillSinMessage(String message) {
        messageInput.sendKeys(message);
    }

    public void markTag(List<SinType> tags) {
        for (SinType tag : tags) {
            $x("//input[@value='" + tag.getXpathValue() + "']").click();
        }
    }

    public void confessSin() {
        confessButton.click();
    }

    public void checkSinStatus(Sin sin) {
        SelenideElement actualSin = getSinFromListElement(sin);
        if (sin.isForgiven()) {
            actualSin.find(("p")).shouldHave(text("forgiven"));
            return;
        }
        actualSin.find(("p")).shouldHave(text("pending"));
    }

    private SelenideElement getSinFromListElement(Sin sin) {
        return listOfSins.find(By.xpath("./li[contains(text(),'" + sin.getTitle() + "')]"));
    }

    public void checkSinVisibleInTheList(String sinTitle) {
        listOfSins.findAll(By.xpath("./li[contains(text(),'" + sinTitle + "')]"))
                .shouldHave(sizeGreaterThan(0));
    }

    public void openDetail(Sin sin) {
        getSinFromListElement(sin).click();
    }

    public void checkDetail(Sin sin) {
        Condition con = and("sinCondition",text(sin.getMessage()),text(sin.getTitle()),text(sin.getAuthor()));
        $("div.detail").shouldHave(con,Duration.ofSeconds(10));
    }
}
