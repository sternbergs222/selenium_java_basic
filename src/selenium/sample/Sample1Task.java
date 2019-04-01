package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
//        TODO:
//         define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//         go to https://kristinek.github.io/site/index2.html
        driver.get("https://kristinek.github.io/site/index2.html");

//         get title of page
        System.out.println(driver.getTitle());

//         get URL of current page
        System.out.println(driver.getCurrentUrl());

        //Sleep for 10 seconds (milisec = s * 1000
        Thread.sleep(10000); //default java function

//         close browser
        driver.quit();
    }
}
