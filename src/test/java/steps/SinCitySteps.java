package steps;

import enumerators.SinType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Sin;
import pages.SinCityPage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class SinCitySteps {
    private SinCityPage sinCityPage;
    private Sin sin;

    @Given("I (am on)(open) sin city page")
    public void iAmOnSinCityPage() {
        getSinCityPage().openPage();
        System.out.println("bohaaaaa");

    }

    @And("I enter sin title {string}")
    public void iEnterSinTitle(String title) {
        sinCityPage.fillSinTitle(title);
    }

    @And("I enter sin author {string}")
    public void iEnterSinAuthor(String author) {
        sinCityPage.fillSinAuthor(author);
    }

    @And("I enter sin message {string}")
    public void iEnterSinMessage(String message) {
        sinCityPage.fillSinMessage(message);
    }

    @When("I confess my sin")
    public void iConfessMySin() {
        sinCityPage.confessSin();
    }

    @Then("My sin appears in the list of all sins {string}")
    public void mySinAppearsInTheListOfAllSins(String title) {
        sinCityPage.checkSinVisibleInTheList(title);
    }

    private SinCityPage getSinCityPage() {
        if (sinCityPage == null) {
            sinCityPage = new SinCityPage();
        }
        return sinCityPage;
    }

    @And("I choose tag {string}")
    public void iChooseTag(String arg0) {
        sinCityPage.markTag(Collections.singletonList(SinType.ROBBERY));
    }


    @And("I select following sins")
    public void iSelectFollowingSins(DataTable dataTable) {
        List<SinType> collect = dataTable.row(0).stream()
                .map(s -> SinType.valueOf(s.toUpperCase().replace(" ", "_")))
                .collect(Collectors.toList());
        sinCityPage.markTag(collect);
    }


    @And("I enter sin title {string}, author {string}  I enter sin message {string}")
    public void iEnterSinTitleAuthorIEnterSinMessage(String title, String author, String message) {
        sinCityPage.fillSinTitle(title);
        sinCityPage.fillSinAuthor(author);
        sinCityPage.fillSinMessage(message);
    }

    @And("I confess a valid Sin without tags")
    public void iConfessAValidSinWithoutTags() {
        sin = new Sin("He sang falsely","Dvorsky","When the bassist plays completely out of rhythm, the musician knows it");
        sinCityPage.fillSinTitle(sin.getTitle());
        sinCityPage.fillSinAuthor(sin.getAuthor());
        sinCityPage.fillSinMessage(sin.getMessage());
        sinCityPage.confessSin();
    }

    @When("I open sin detail")
    public void iOpenSinDetail() {
        sinCityPage.openDetail(sin);
    }

    @Then("The information are correct")
    public void theInformationAreCorrect() {
        sinCityPage.checkDetail(sin);
    }
}

