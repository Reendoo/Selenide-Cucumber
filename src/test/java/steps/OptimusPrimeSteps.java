package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OptimusPage;

public class OptimusPrimeSteps {
    private OptimusPage page;

    @Given("I am on the Optimus prime page")
    public void iAmOnTheOptimusPrimePage() {
        getOptimusPage().openPage();
    }

    @When("I Enter number {int}")
    public void iEnterNumber(int i) {
        page.enterNumber(String.valueOf(i));
    }

    @And("If i ask Optimus if it is prime")
    public void ifIAskOptimusIfItIsPrime() {
        page.clickOnButton();
    }

    private OptimusPage getOptimusPage() {
        if (page == null) {
            page = new OptimusPage();
        }
        return page;
    }

    @Then("Optimus says that number is {}")
    public void optimusSaysThatNumberIs(String s) {
        if (s.contains("NOT")) {
            page.checkResult(false);
            return;
        }
        page.checkResult(true);
    }
}
