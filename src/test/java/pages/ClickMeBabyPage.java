package pages;

import base.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickMeBabyPage extends TestBase {
    private final SelenideElement clickMeButton = $("button");
    private final SelenideElement numberOfClicks = $(byId("clicks"));
    private final SelenideElement clickDescription = $("div p[class=\"description\"]");

    public ClickMeBabyPage() {
        page(this);
    }

    public void openPage() {
        open("/clickmebaby.php");
    }

    public void clickOnButton() {
        clickMeButton.click();
    }

    public String getNumberOfClicks() {
        System.out.println(numberOfClicks.getText());
        return numberOfClicks.getText();
    }

    public String getClickDescription() {
        return clickDescription.getText();
    }

    public void checkClickDescription(String expectedDescription) {
        assertEquals(expectedDescription, getClickDescription());
    }

    public void check(String description) {
        String s;
        int i = Integer.parseInt(numberOfClicks.getText());
        if (i == 1) {
            clickDescription.shouldHave(exactText("klik"));
            s="klik";
        } else if (i == 2 || i == 3 || i == 4) {
            clickDescription.shouldHave(exactText("kliky"));
            s="kliky";
        } else {
            clickDescription.shouldHave(exactText("klikov"));
            s="klikov";
        }
        assertEquals(description,s);
    }
}
