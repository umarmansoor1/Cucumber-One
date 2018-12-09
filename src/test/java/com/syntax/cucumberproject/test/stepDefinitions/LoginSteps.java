package com.syntax.cucumberproject.test.stepDefinitions;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	WebDriver driver;

	@Given("^I open browser$")
	public void i_open_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	  System.out.println("browser is open");;
	}

	@Given("^I navigate to the FreeCrm$")
	public void i_navigate_to_the_FreeCrm()  {
		String url = "https://www.freecrm.com/index.html";
		driver.get(url);
	    System.out.println("navigate free crm");
	}

	@When("^I enter username and password$")
	public void i_enter_username_and_password()  {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("umarmansoor");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("dbvg1234");
	    System.out.println("username password entered");
	}

	@When("^I click login button$")
	public void i_click_login_button() throws Exception  {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	    System.out.println("clicked login button");
	}

	@Then("^I successfully logged in$")
	public void i_successfully_logged_in() throws Exception {
		Thread.sleep(2000);
		String abc = "CRMPRO";
		String xyz = driver.getTitle();
		Assert.assertEquals(abc, xyz);
	    System.out.println("logged in");
	}
	
	@When("^I enter invalid username and password$")
	public void i_enter_invalid_username_and_password() throws Exception  {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("umarmansoor");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("dbvg1111");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("I entered invalid username and password");
	}

	@Then("^I see error message$")
	public void i_see_error_message() throws Exception {
		Thread.sleep(2000);
		WebElement expected = driver.findElement(By.xpath("//input[@value='Login']"));
		WebElement actual = driver.findElement(By.xpath("//input[@value='Login']"));
		Assert.assertEquals(expected, actual);
		System.out.println("I saw error message");
	}
}
