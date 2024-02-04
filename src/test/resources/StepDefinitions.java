import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static junit.framework.TestCase.assertTrue;

public class StepDefinitions {
    public WebDriver driver;

    @Before
    public void setup(){
        System.out.println("before method call");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
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
