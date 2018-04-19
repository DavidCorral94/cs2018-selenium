import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestingSauceLabs {
    private static WebDriver driver;
    private WebElement element;
    public static final String USERNAME = "YOUR_USER_NAME";
    public static final String ACCESS_KEY = "YOUR_ACCESS_KEY"; // It is not your password!
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    @BeforeClass
    public static void openSauceLabs() throws MalformedURLException {
        /* Windows & Chrome */
        /*DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "latest");
        /* Linux & Firefox */
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "45.0");
        driver = new RemoteWebDriver(new URL(URL), caps);
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
            System.out.println("Exception getting 'textoError'");
        }
        Assert.assertEquals(expectedResult, result);
        System.out.println("Ending test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
    }


    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
