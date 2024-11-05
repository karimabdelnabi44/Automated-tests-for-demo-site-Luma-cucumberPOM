package NewCUtests;

import NewCUpages.P01_NewCUpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class T01_NewCUtest {

    public static WebDriverWait wait;
    public static ChromeDriver driver;
    public static String Fname = "Karim1";
    public static String Lname = "Saleh1";
    public static String Email = "Kanew@gmail.com";
    public static String Passw = "AEdr334455640";
    P01_NewCUpage P01Rigstercu = new P01_NewCUpage();

    @Given("user open browser")
    public void user_open_browser(){
        driver = new ChromeDriver();
    }
    @And("user Open website URL")
    public void user_Open_website_URL(){
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @When("user click create account")
    public void user_click_create_account(){
        P01Rigstercu.getCreateAccount().click();
    }
    @And("user enter firstname")
    public void user_enter_firstname(){
        P01Rigstercu.sendFirstname().sendKeys("Karim");
    }
    @And("user enter lastname")
    public void user_enter_lastname(){
        P01Rigstercu.sendLastname().sendKeys("Saleh");
    }
    @And("user enter valid email")
    public void user_enter_email() {
        P01Rigstercu.sendEmail().sendKeys("kgggg@gmail.com");
    }
    @And("user enter password")
    public void user_enter_password(){
        P01Rigstercu.sendPassward().sendKeys("12345678");
    }
    @And("user leave confirm password empty")
    public void user_leave_confirm_password_empty (){
        P01Rigstercu.sendPasswardConfirmation().sendKeys();
    }
    @And("user enter different confirmation password")
    public void user_enter_different_confirmation_password(){
        P01Rigstercu.sendPasswardConfirmation().sendKeys("123338883");
    }
    @And("user click on submit")
    public void user_click_on_submit(){
        P01Rigstercu.clickSubmit().click();
    }
    @And("user enter attached data")
    public void user_enter_attached_data(){
        P01Rigstercu.sendFirstname().sendKeys(T01_NewCUtest.Fname);
        P01Rigstercu.sendLastname().sendKeys(T01_NewCUtest.Lname);
        P01Rigstercu.sendEmail().sendKeys(T01_NewCUtest.Email);
        P01Rigstercu.sendPassward().sendKeys(T01_NewCUtest.Passw);
        P01Rigstercu.sendPasswardConfirmation().sendKeys(T01_NewCUtest.Passw);
    }
    @Then("user get required emty field message")
    public void uuser_get_required_emty_field_message(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://magento.softwaretestingboard.com/customer/account/create/");
        String errorMessage = P01Rigstercu.findErrorMessage().getText();;
        Assert.assertEquals(errorMessage, "This is a required field.");
        driver.quit();
    }
    @Then("user get enter confirmed password")
    public void user_get_enter_confirmed_password(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://magento.softwaretestingboard.com/customer/account/create/");
        String errorMessage = P01Rigstercu.findErrorMessage().getText();;
        Assert.assertEquals(errorMessage, "Please enter the same value again.");
        driver.quit();
    }
    @Then("User get directed to account")
    public void User_get_directed_to_account(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://magento.softwaretestingboard.com/customer/account/");
    }
    @And("user get account data")
    public void user_get_account_data(){
        String shownfname = P01Rigstercu.getShownFname().getText();
        String shownlname = P01Rigstercu.getShownLname().getText();
        String shownemail = P01Rigstercu.getShownEmail().getText();
        Assert.assertTrue(shownfname.contains(Fname));
        Assert.assertTrue(shownlname.contains(Fname));
        Assert.assertTrue(shownemail.contains(Fname));
        driver.quit();
    }
    }




