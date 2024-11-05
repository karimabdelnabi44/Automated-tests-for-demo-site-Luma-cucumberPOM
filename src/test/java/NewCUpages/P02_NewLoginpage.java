package NewCUpages;

import NewCUtests.T02_NewCulogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_NewLoginpage {
    public WebElement clickSignin(){
        return T02_NewCulogin.driver.findElement(By.linkText("Sign In")) ;
    }
    public WebElement enterEmail(){
        return T02_NewCulogin.driver.findElement(By.id("email"));
    }
    public WebElement enterPassward(){
        return T02_NewCulogin.driver.findElement(By.id("pass"));
    }
    public WebElement clickLogin(){
        return T02_NewCulogin.driver.findElement(By.id("send2"));
    }
    public WebElement welcomeMessageElement(){
        return T02_NewCulogin.driver.findElement(By.cssSelector(".greet.welcome span"));
    }
}
