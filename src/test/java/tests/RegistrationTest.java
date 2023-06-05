package tests;



import base.TestBase;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase {

    @Test
    public void testSuccessfulRegistration() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage();
        registrationPage.enterEmail("matko@vajcia.sk");
    }
}
