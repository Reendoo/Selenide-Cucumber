package steps;

import enumerators.BananaTableColumn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BananaPage;

import java.util.Map;

public class BananaSteps {
    private BananaPage bananaPage;

    @Given("^I am on banana shop page$")
    public void iAmOnBananaShopPage() {
        getBananaPage().openPage();
    }

    @When("^price for one banana is 1.5$")
    public void priceForOneBananaIs() {
    }

    @When("^I have chosen 1 banana$")
    public void iHaveChosenBanana() {
        getBananaPage().enterBananaAmount("1");
        getBananaPage().submitBananaAmount();
    }

    private BananaPage getBananaPage() {
        if (bananaPage == null) {
            bananaPage = new BananaPage();
        }
        return bananaPage;
    }

    @Then("values in table are following")
    public void valuesInTableAreFollowing(DataTable table) {
        Map<String, String> tableMap = table.asMap();
        System.out.println(tableMap);
        bananaPage.fakeCheck(tableMap);
    }
}
