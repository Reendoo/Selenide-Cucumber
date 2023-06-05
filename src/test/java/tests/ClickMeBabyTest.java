package tests;

import base.TestBase;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import pages.ClickMeBabyPage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickMeBabyTest extends TestBase {

    @Test
    public void testNumberOfClicks() {
        ClickMeBabyPage clickMeBabyPage = new ClickMeBabyPage();
        clickMeBabyPage.openPage();
        clickMeBabyPage.clickOnButton();
        assertEquals("1", clickMeBabyPage.getNumberOfClicks());
    }

    @Test
    public void test() {
        ClickMeBabyPage clickMeBabyPage = new ClickMeBabyPage();
        clickMeBabyPage.openPage();
        $(byId("clicks")).shouldHave(exactText("0").because("Initial should be 0"));
        $x("/html/body/div/div[2]/p").shouldHave(exactText("klikov").because("Initial should be >>> klikov"));
        for (int i = 1; i <= 10; i++) {
            $(byId("clickMe")).click();
            $(byId("clicks")).shouldHave(exactText(String.valueOf(i)).because("test incrementation"));
            if (i == 1) {
                $x("/html/body/div/div[2]/p").shouldHave(exactText("klik").because("should be >>> 1 klik"));
                continue;
            }
            if (i < 5) {
                $x("/html/body/div/div[2]/p").shouldHave(exactText("kliky").because("should be >>> 2,3,4 kliky"));
                continue;
            }
            $x("/html/body/div/div[2]/p").shouldHave(exactText("klikov").because("should be >>> 5,6,...,n klikov"));
        }
    }
}
