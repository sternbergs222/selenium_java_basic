package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

import java.awt.*;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        WebElement textArea = driver.findElement(By.id("numb"));
        //TextArea.click();
        String TextThatIWrite = "Hello";
        textArea.sendKeys(TextThatIWrite);
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        WebElement announcment = driver.findElement(By.id("ch1_error"));
        assertEquals("Please enter a number",announcment.getText());

    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement textArea = driver.findElement(By.id("numb"));
        String NumberThatIWrite = "48";
        textArea.sendKeys(NumberThatIWrite);
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        WebElement announcment = driver.findElement(By.id("ch1_error"));
        assertEquals("Number is too small",announcment.getText());
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement textArea = driver.findElement(By.id("numb"));
        String NumberOverHundred = "101";
        textArea.sendKeys(NumberOverHundred);
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        WebElement announcment = driver.findElement(By.id("ch1_error"));
        assertEquals("Number is too big",announcment.getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement textArea = driver.findElement(By.id("numb"));
        String NumberSquare = "81";
        textArea.sendKeys(NumberSquare);
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 81 is 9.00", alert.getText());

    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement textArea = driver.findElement(By.id("numb"));
        String NumberNotSquare = "57";
        textArea.sendKeys(NumberNotSquare);
        WebElement button = driver.findElement(By.className("w3-btn"));
        button.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 57 is 7.55", alert.getText());
    }
}
