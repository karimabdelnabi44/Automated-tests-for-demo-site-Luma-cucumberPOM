package NewCUtests;

import NewCUpages.P02_NewLoginpage;
import NewCUpages.P04_NewLandingPagecu;
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
import java.util.List;

public class T04_NewLandingPagecu {
    public static ChromeDriver driver;
    public static WebDriverWait wait;
    P04_NewLandingPagecu P04Land = new P04_NewLandingPagecu();

    @Given("users open new chrome browser")
    public void users_open_new_chrome_browser() {
        driver = new ChromeDriver();
    }

    @And("user go to url hot teller section")
    public void user_go_to_url_hot_teller_section() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        P04Land.goHotSellersSection();
    }

    @And("user check items prices in usd")
    public void user_check_items_prices_in_usd() {
        for (int i = 0; i < 6; i++) {
            boolean x = driver.findElements(By.className("price")).get(i).getText().contains("$");
            Assert.assertTrue(x);
        }
        for (int x = 0; x < 6; x++) {
            String price = P04Land.getProductPrices().get(x).getText();
            String priceValue = price.replace("$", "").trim();
            Assert.assertTrue(priceValue.matches("\\d+\\.\\d{2}"));
        }
    }

    @And("user check add to cart appears")
    public void user_check_add_to_cart_appears() {
        int Products = P04Land.getProductCount();
        for (int y = 0; y < Products; y++) {
            Actions Hoverproduct = new Actions(driver);
            WebElement productItem = P04Land.getProductItems().get(y);
            Hoverproduct.moveToElement(productItem).perform();
            WebElement addToCartButton = P04Land.getAddToCartButton(productItem);
            ;
            Assert.assertTrue(addToCartButton.isDisplayed());
        }
    }

    @And("user choose product")
    public void user_choose_product() {
        P04Land.findBreatheEasyTank();
    }

    @And("user choose size")
    public void user_choose_size() {
        P04Land.clickBreatheEasyTankSize().click();
    }
    @And("user choose color")
    public void user_choose_color(){
        P04Land.clickBreatheEasyTankColor().click();
    }
    @When("user click add to cart")
    public void user_click_add_to_cart(){
        P04Land.clickAddtoCart().click();
    }
    @Then("cart count is updated")
    public void cart_count_is_updated(){
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success")));
        String successMessage = successMessageElement.getText();
        Assert.assertTrue(successMessage.contains("You added Breathe-Easy Tank to your shopping cart."));
        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".counter-number")));
        Assert.assertEquals(cartIcon.getText(), "1");
    }


        /*

    @Test ()
    void TC3 (){
        P0Land.goHotSellersSection();
        P0Land.findBreatheEasyTank();
        P0Land.clickBreatheEasyTankSize().click();
        P0Land.clickBreatheEasyTankColor().click();
        P0Land.clickAddtoCart().click();
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success")));
        String successMessage = successMessageElement.getText();
        Assert.assertTrue(successMessage.contains("You added Breathe-Easy Tank to your shopping cart."));
        WebElement cartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".counter-number")));
        Assert.assertEquals(cartIcon.getText(), "1");
    */

}
