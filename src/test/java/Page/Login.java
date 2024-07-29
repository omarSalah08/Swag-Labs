package Page;

import StepDef.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login {

    public WebElement username()
    {
        WebElement username = Hooks.driver.findElement(By.id("user-name"));
        return username;
    }

    public WebElement password()
    {
        WebElement password = Hooks.driver.findElement(By.id("password"));
        return password;
    }

    public WebElement loginButton()
    {
        WebElement loginButton = Hooks.driver.findElement(By.id("login-button"));
        return loginButton;
    }

    public void dataEnter(String username, String password)
    {
        username().clear();
        username().sendKeys(username);

        password().clear();
        password().sendKeys(password);
    }

    public WebElement failMessage()
    {
        WebElement message = Hooks.driver.findElement(By.className("error-message-container"));
        System.out.println(message);
        return message;
    }




}
