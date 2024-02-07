package org.ankit;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    public WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        System.out.println("before method call");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
//        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--ignore-ssl-errors=yes");
//        options.addArguments("--ignore-certificate-errors");
        driver = new RemoteWebDriver(new URL("http://172.18.0.2:4444/wd/hub"),options);
    }
    @Given("I open the Google homepage")
    public void i_open_the_google_homepage() {
        driver.get("https://www.google.com");
    }
    @When("I search for {string}")
    public void i_search_for(String string) {
        driver.findElement(By.name("q")).sendKeys("Cucumber with Selenium" + Keys.ENTER);
    }
    @Then("I should see search results")
    public void i_should_see_search_results() {
        assertTrue(driver.getTitle().contains("Cucumber with Selenium"));
        driver.quit();
    }

}
