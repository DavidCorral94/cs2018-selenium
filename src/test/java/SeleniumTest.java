import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private static ChromeDriver driver;
    WebElement element;

    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void invalidCampusLogin() {

        System.out.println("Starting test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        driver.get("https://campusvirtual.uca.es/es/intranet/login");
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        String result = "";
        String expectedResult = "ERROR:";
        try {
            element = driver.findElement(By.className("textoError"));
            result = element.getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(expectedResult, result);
        System.out.println("Ending test " + new Object() {}.getClass().getEnclosingMethod().getName());
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
