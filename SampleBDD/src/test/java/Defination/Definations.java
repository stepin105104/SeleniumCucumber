package Defination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

 

public class Definations
{
	    WebDriver driver;
	    @Given("^I launch chrome browser$")
	    public void i_launch_chrome_browser() throws Throwable 
	    {
	    	// Write code here that turns the phrase above into concrete actions
	    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			  driver = new ChromeDriver();
			  driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html"); 
	 	        driver.manage().window().maximize();
	 	        Thread.sleep(3000);
	 	        JavascriptExecutor js = (JavascriptExecutor) driver;
	 	        js.executeScript("window.scrollBy(0,500)");
	 	        Thread.sleep(2000);
    	}
	    
        @When("^I enter the details$")
        public void i_enter_url() throws Throwable
        {
        	
 	        driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")).click();
 	        Thread.sleep(3000);
 	        driver.switchTo().alert().accept();
 	        Thread.sleep(3000);
 	        String actual = driver.findElement(By.xpath("//*[text()='You pressed OK!']")).getText();
 	        Assert.assertEquals(actual, "You pressed OK!");
        }   
        
        @Then("^I should see next page$")
        public void i_should_see_home_screen() throws Throwable 
        {
        	driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]/button")).click();
            Thread.sleep(3000);
            driver.switchTo().alert().sendKeys("sushank");
            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            Thread.sleep(3000);
            driver.close();
        }
        
        @Given("^I launch Firefox browser$")
        public void i_launch_Firefox_browser() throws Throwable {
        	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
			  driver = new FirefoxDriver();
			  driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html"); 
	 	        driver.manage().window().maximize();
	 	        Thread.sleep(3000);
	 	        JavascriptExecutor js = (JavascriptExecutor) driver;
	 	        js.executeScript("window.scrollBy(0,500)");
	 	        Thread.sleep(2000);
        }
        

}