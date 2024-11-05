package NewCUtests;

import NewCUpages.P03_NewWishlistCu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class T03_NewWishlistCu {

    public static ChromeDriver driver;
    public static WebDriverWait wait;
    P03_NewWishlistCu P3Wishcu = new P03_NewWishlistCu();

    @Given("user open new browser")
    public void user_open_new_browser() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @And("user move to hot seller")
    public void use_move_to_hot_seller(){
        P3Wishcu.gooHotSellersSection();
    }
    @And("user hover on BreathEasyTank")
    public void user_hover_on_BreathEasyTank(){
        Actions Hoverproduct = new Actions(driver);
        Hoverproduct.moveToElement(P3Wishcu.hoverBreathEasyTank()).perform();
        WebDriverWait EX = new WebDriverWait(driver,Duration.ofSeconds(5));
        EX.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@title='Add to Wish List'])[2]")));
    }
    @When("user click add to wishlist")
    public void user_click_add_to_wishlist(){
        P3Wishcu.addToWishList().click();
    }
    @Then("user get directed to log in page")
    public void user_get_directed_to_log_in_page(){
        boolean T = P3Wishcu.findSpan().isDisplayed();
        Assert.assertTrue(T);
        driver.quit();
    }
    @And("user enter login email and pass")
    public void user_enter_login_email_and_pass(){
        P3Wishcu.enterLoginEmail().sendKeys(T01_NewCUtest.Email);
        P3Wishcu.enterLoginPass().sendKeys(T01_NewCUtest.Passw);
        P3Wishcu.clickLog().click();
    }
    @And("user directed to whishlist with product")
    public void user_directed_to_whishlist_with_product(){
        wait.until(ExpectedConditions.titleContains("My Wish List"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("wishlist"));
        WebElement productElement = P3Wishcu.hoverBreathEasyTank();
        String expectedProductName = productElement.getAttribute("title");
        WebElement wishlistProduct = P3Wishcu.checkItem();
        String actualProductName = wishlistProduct.getText();
        Assert.assertEquals(actualProductName, expectedProductName);
        driver.quit();
    }
}