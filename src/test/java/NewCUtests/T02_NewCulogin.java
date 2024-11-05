package NewCUtests;

import NewCUpages.P02_NewLoginpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class T02_NewCulogin {
    public static ChromeDriver driver ;
    public static WebDriverWait wait;
    P02_NewLoginpage P02Log = new P02_NewLoginpage();

    @Given("user Open browser chrome")
    public void user_open_browser(){
        driver = new ChromeDriver();
    }
    @And("user Open website url")
    public void user_Open_website_URL() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @And("user click sign in")
    public void user_click_sign_in(){
        P02Log.clickSignin().click();
    }
    @When("user enter login data")
    public void user_enter_login_data(){
        P02Log.enterEmail().sendKeys(T01_NewCUtest.Email);
        P02Log.enterPassward().sendKeys(T01_NewCUtest.Passw);
        P02Log.clickLogin().click();
    }
    @Then("User get directed to Profile")
    public void User_get_directed_to_Profile(){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://magento.softwaretestingboard.com/");
    }
    @And("confirm account information")
    public void confirm_account_information(){
        String actualWelcomeMessage = P02Log.welcomeMessageElement().getText();
        System.out.println("Actual Welcome Message: '" + actualWelcomeMessage + "'");
        String expectedWelcomeMessage = "Welcome, " + T01_NewCUtest.Fname + " " + T01_NewCUtest.Lname + "!";
        Assert.assertTrue(actualWelcomeMessage.contains(T01_NewCUtest.Fname + " " + T01_NewCUtest.Lname),
                "Welcome message does not contain the expected first and last name");
        Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage);
    }
}








