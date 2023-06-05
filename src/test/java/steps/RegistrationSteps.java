package steps;

import io.cucumber.java.en.*;
import pages.RegistrationPage;

public class RegistrationSteps {
    public static final String VALID_EMAIL = "sdsabik@fdf";
    public static final String VALID_NAME = "Ferdo";
    private RegistrationPage registrationPage;
    private static final String INVALID_PASSWORD = "1234";
    private static final String VALID_PASSWORD = "12345";

    @Given("^I am on the registration page$")
    public void iAmOnTheRegistrationPage() {
        getRegistrationPage().openPage();
    }

    @And("^I enter email (.*)$")
    public void iEnterEmailMatkoMatkoSk(String email) {
        getRegistrationPage().enterEmail(email);
    }

    @And("^I enter name (.*)$")
    public void iEnterNameMatko(String name) {
        getRegistrationPage().enterName(name);
    }

    @And("^I enter surname (.*)$")
    public void iEnterSurname(String surname) {
        getRegistrationPage().enterSurname(surname);
    }

    @But("^I enter password (.*)$")
    public void iEnterPassword(String password) {
        registrationPage.enterPassword(password);

    }

    @But("^I repeat password (.*)$")
    public void iRepeatPassword(String password) {
        registrationPage.enterPasswordRepeat(password);
    }

    @And("^I check robot checkbox$")
    public void iCheckRobotCheckbox() {
        getRegistrationPage().checkRobotCheckbox();
    }

    @When("^I click on registration button$")
    public void iClickOnRegistrationButton() {
        getRegistrationPage().submitRegistration();
    }

    private RegistrationPage getRegistrationPage() {
        if (registrationPage == null) {
            registrationPage = new RegistrationPage();
        }
        return registrationPage;
    }

    @Then("^The registration fails$")
    public void theRegistrationFails() {
        getRegistrationPage().checkRegistrationFailed();
    }

    @When("I enter invalid password")
    public void iEnterInvalidPassword() {
        registrationPage.enterPassword(INVALID_PASSWORD);
    }

    @But("I repeat invalid password")
    public void iRepeatInvalidPassword() {
        registrationPage.enterPasswordRepeat(INVALID_PASSWORD);
    }

    @When("I enter a repeat valid password")
    public void iEnterARepeatValidPassword() {
        registrationPage.enterPassword(VALID_PASSWORD);
        registrationPage.enterPasswordRepeat(VALID_PASSWORD);
    }

    @Then("The registration succeeds")
    public void theRegistrationSucceeds() {
        getRegistrationPage().checkRegistrationSucceeded();
    }

    @And("I enter valid email, name, surname")
    public void iEnterValidEmailNameSurname() {
        registrationPage.enterEmail(VALID_EMAIL);
        registrationPage.enterName(VALID_NAME);
        registrationPage.enterSurname("Mravec");
    }
}

