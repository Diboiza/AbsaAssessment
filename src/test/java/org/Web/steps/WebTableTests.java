package org.Web.steps;

import com.github.javafaker.Faker;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.Web.pages.WebTablePage;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WebTableTests {

    /**
     * this method automatically downloads chromedriver using webdriver manager
     * useful for when another person who will be running the project
     * won't have issues with chromedriver if their versions of chrome
     * are not the same with the driver executable version mismatch
     * if it was explicitly placed in the project
     */
    @Managed(driver = "chrome")
    WebDriver driver;
    WebTablePage webTablePage;

    /**
     * Java Faker generates fake data which uses real info based on the locale you pass
     * this then solves the big problem of having static data that looks the same
     */
    Faker faker = new Faker(new Locale("en-ZA"));
    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String username = faker.name().fullName();
    String password = faker.internet().password();
    String email = faker.internet().emailAddress();
    String cellNumber = faker.phoneNumber().cellPhone();

    @Test
    void verifyUserListTable()
    {
        webTablePage.NavigateToTheWebTablePage();
        webTablePage.verifyIamOnTheHomePage();
        webTablePage.addUser(firstname, lastname,username,password,email,cellNumber);
        webTablePage.verifyUserIsAdded(firstname);
    }

}
