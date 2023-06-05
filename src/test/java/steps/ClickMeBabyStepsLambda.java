package steps;

import io.cucumber.java8.En;
import pages.ClickMeBabyPage;

import java.util.stream.IntStream;

public class ClickMeBabyStepsLambda implements En {
    private ClickMeBabyPage clickMePage;

    public ClickMeBabyStepsLambda() {
        Given("LAMBDA I am on click me baby page", () -> getClickMeBabyPage().openPage());

        When("LAMBDA I click on button", () -> clickMePage.clickOnButton());

        When("LAMBDA I click {int} time(s) on button", (Integer n) -> {
            IntStream.range(0, n).forEach(i -> clickMePage.clickOnButton());
        });

        Then("LAMBDA description is {string}", (String descr) -> clickMePage.check(descr));

        When("LAMBDA I click on buttonNTimes {int}", (Integer countClick) -> {
            IntStream.range(0, countClick).forEach(i -> clickMePage.clickOnButton());
        });

        Then("LAMBDA Description is {string}", (String desc) -> clickMePage.check(desc));
    }

    private ClickMeBabyPage getClickMeBabyPage() {
        if (clickMePage == null) {
            clickMePage = new ClickMeBabyPage();
        }
        return clickMePage;
    }

}