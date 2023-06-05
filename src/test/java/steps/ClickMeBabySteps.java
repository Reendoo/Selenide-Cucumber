package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ClickMeBabyPage;

public class ClickMeBabySteps {
    private ClickMeBabyPage clickMePage;

    @Given("I am on click me baby page")
    public void iAmOnClickMeBabyPage() {
        getClickMeBabyPage().openPage();
    }

    @When("I click on button")
    public void iClickOnButton() {
        clickMePage.clickOnButton();
    }

    @When("I click {int} time(s) on button")
    public void iClickOnButtonN(int n) {
        for (int i = 0; i <n; i++) {
            clickMePage.clickOnButton();
        }
    }

    @Then("description is {string}")
    public void descriptionIsKlik(String string) {
        clickMePage.check(string);
    }

    @When("I click on buttonNTimes {int}")
    public void iClickOnButtonNTimes(int countClick) {
        for (int i = 0; i < countClick; i++) {
            clickMePage.clickOnButton();
        }
    }

    @Then("Description is {string}")
    public void descriptionIs(String s) {
        clickMePage.check(s);
    }

    private ClickMeBabyPage getClickMeBabyPage() {
        if (clickMePage == null) {
            clickMePage = new ClickMeBabyPage();
        }
        return clickMePage;
    }


}