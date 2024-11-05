package NewCUpages;

import NewCUtests.T04_NewLandingPagecu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P04_NewLandingPagecu {
    public  void goHotSellersSection() {
        T04_NewLandingPagecu.driver.findElement(By.xpath("//h2[contains(text(),'Hot Sellers')]"));
    }
    public List<WebElement> getProductPrices() {
        return T04_NewLandingPagecu.driver.findElements(By.cssSelector(".product-item .price"));
    }
    public int getProductCount() {
        return T04_NewLandingPagecu.driver.findElements(By.className("product-item")).size();
    }
    public List<WebElement> getProductItems() {
        return T04_NewLandingPagecu.driver.findElements(By.className("product-item"));
    }
    public WebElement getAddToCartButton(WebElement productItem) {
        return productItem.findElement(By.cssSelector("button[class='action tocart primary']"));
    }
    public void findBreatheEasyTank(){
        T04_NewLandingPagecu.driver.findElement(By.xpath("//a[contains(@title,'Breathe-Easy Tank')]"));
    }
    public WebElement clickBreatheEasyTankSize(){
        return T04_NewLandingPagecu.driver.findElement(By.xpath("//div[@class='swatch-opt-1812']//div[@id='option-label-size-143-item-168']"));
    }
    public WebElement clickBreatheEasyTankColor(){
        return T04_NewLandingPagecu.driver.findElement(By.xpath("//div[@id='option-label-color-93-item-60']"));
    }
    public WebElement clickAddtoCart(){
        return T04_NewLandingPagecu.driver.findElement(By.xpath("//li[2]//div[1]//div[1]//div[4]//div[1]//div[1]//form[1]//button[1]"));
    }
    //
}

