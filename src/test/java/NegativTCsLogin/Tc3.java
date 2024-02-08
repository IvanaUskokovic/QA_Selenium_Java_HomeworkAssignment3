package NegativTCsLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Tc3 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/ ");

        String validUsername = "student";
        String validPassword = "Password123";

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement loginPageButton = driver.findElement(By.linkText("Test Login Page"));
        loginPageButton.click();

        // 3. invalid username and password

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student1");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password1234");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        Assert.assertTrue(submitButton.isDisplayed());

        WebElement errorField = driver.findElement(By.id("error"));
        Assert.assertTrue(errorField.isDisplayed());

        String actualResult2 = errorField.getText();
        Assert.assertEquals(actualResult2, "Your username is invalid!"); // bug

        driver.quit();

    }
}
