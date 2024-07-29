package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver = null;

    @Before
    public static void open_browser()
    {
        //new object from chrome driver
        driver = new ChromeDriver();

        //configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //navigate to the website
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @After
    public static void close_browser() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.quit();
    }

}
