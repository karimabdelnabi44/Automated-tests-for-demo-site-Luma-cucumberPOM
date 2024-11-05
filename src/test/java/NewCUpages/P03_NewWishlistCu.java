package NewCUpages;

import NewCUtests.T03_NewWishlistCu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P03_NewWishlistCu {

        public  void gooHotSellersSection() {
            T03_NewWishlistCu.driver.findElement(By.xpath("//h2[contains(text(),'Hot Sellers')]"));
        }
        public WebElement hoverBreathEasyTank(){
            return T03_NewWishlistCu.driver.findElement(By.xpath("//a[contains(@title,'Breathe-Easy Tank')]"));
        }
        public WebElement addToWishList(){
            return T03_NewWishlistCu.driver.findElement(By.xpath("(//a[@title='Add to Wish List'])[2]"));
        }
        public WebElement findSpan(){
            return T03_NewWishlistCu.driver.findElement(By.xpath("//span[@class='base']"));
        }
        public WebElement enterLoginEmail(){
            return T03_NewWishlistCu.driver.findElement(By.xpath("//input[@id='email']"));
        }
        public WebElement enterLoginPass(){
            return T03_NewWishlistCu.driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']"));
        }
        public WebElement clickLog(){
            return T03_NewWishlistCu.driver.findElement(By.cssSelector("fieldset[class='fieldset login'] div[class='primary'] span"));
        }
        public WebElement checkItem(){
            return T03_NewWishlistCu.driver.findElement(By.xpath("//strong[@class='product-item-name']/a"));
        }



    }

