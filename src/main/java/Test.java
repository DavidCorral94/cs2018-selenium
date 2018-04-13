import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        // Declaration and instantiation of objects/variables
        // Firefox
        // System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
        // WebDriver driver = new FirefoxDriver();

        // Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Reach website
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // Launch browser
        driver.get(baseUrl);

        // Get the actual value of the title
        actualTitle = driver.getTitle();

        // Compare the actual title of the page with the expected one and print
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        // Now testing Facebook
        baseUrl = "http://www.facebook.com";
        String tagName;

        // Open Facebook website
        driver.get(baseUrl);

        // Get tagname for the element with id "email"
        tagName = driver.findElement(By.id("email")).getTagName();

        // Print it
        System.out.println(tagName);

        // Close
        driver.close();
    }

    public void mixActionsFromSlides(){

        /////////////////
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebElement select = driver.findElement(By.tagName("select"));
        List<WebElement> allOptions = select.findElements(By.tagName("option"));
        for(WebElement option : allOptions){
            System.out.println(String.format("Value is: %s", option.getAttribute("value")));
            option.click();
        }

        /////////////////
        Select selectAux = new Select(driver.findElement(By.tagName("select")));
        selectAux.deselectAll();
        selectAux.selectByVisibleText("Edam");

        /////////////////
        WebElement element = driver.findElement(By.id("submit"));
        element.submit();

        /////////////////
        Alert alert = driver.switchTo().alert();

        /////////////////
        driver.navigate().forward();
        driver.navigate().back();
    }

}
