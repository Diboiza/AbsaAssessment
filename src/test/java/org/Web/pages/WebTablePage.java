package org.Web.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.rest.Ensure;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;

public class WebTablePage extends PageObject {

    @FindBy(xpath = "/html/body/table")
    private WebElement table;

    @FindBy(xpath = "/html/body/table/thead/tr[3]/th[1]/span")
    private WebElement FirstNameHeader;

    @FindBy(xpath = "/html/body/table/thead/tr[2]/td/button")
    private WebElement addUserBtn;

    @FindBy(name = "FirstName")
    private WebElement firstNameField;

    @FindBy(name = "LastName")
    private WebElement lastNameField;

    @FindBy(name = "UserName")
    private WebElement userNameField;

    @FindBy(name = "Password")
    private WebElement passwordNameField;

    @FindBy(xpath = "/html/body/div[2]/div[2]/form/table/tbody/tr[5]/td[2]/label[1]/input")
    private WebElement companyAAA;

    @FindBy(name = "RoleId")
    WebElementFacade roleDropDown;

    @FindBy(name = "Email")
    private WebElement  emailField;

    @FindBy(name = "Mobilephone")
    private WebElement  mobilephoneField;

    @FindBy(xpath = "/html/body/div[2]/div[3]/button[2]")
    private WebElement saveBtn;

    @FindBy(xpath = "/html/body/div[2]/div[3]/button[1]")
    private WebElement closeBtn;


    public void NavigateToTheWebTablePage(){
        openUrl("https://www.way2automation.com/angularjs-protractor/webtables/");
        waitABit(3000);
    }

    /**
     * The below method reads the contents of an HTML table as a list of Maps
     * where each map contains the cell values for a row indexed by the corresponding heading
     * which I will use to assert that the users entered are displayed on the table
     * @return
     */
    public List<Map<Object, String>> getTableData(){
        return rowsFrom(table);
    }
    public void verifyIamOnTheHomePage()
    {
        shouldBeVisible(FirstNameHeader);
    }

    public void addUser(String firstname,String lastname,String username,String password,String email,String cellNumber)
    {
        clickOn(addUserBtn);
        typeInto(firstNameField, firstname);
        typeInto(lastNameField, lastname);
        typeInto(userNameField, username);
        typeInto(passwordNameField,password);
        clickOn(companyAAA);
        roleDropDown.selectByVisibleText("Customer");
        typeInto(emailField, email);
        typeInto(mobilephoneField, cellNumber);
        clickOn(saveBtn);
    }

    /**
     * here we are then asserting that the first name value of the table header
     * firstname is equal to the firstname of the user
     * during manual testing i saw that it actually adds the user to the top of the list
     * hence this approach
     * @param firstname
     */
    public void verifyUserIsAdded(String firstname){
        Assert.assertEquals(getTableData().get(0).get("First Name"), firstname);
    }
}
