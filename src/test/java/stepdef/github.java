package stepdef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class github {
 
WebDriver driver;
@Given("user has registered into TestMeApp")
public void user_has_registered_into_TestMeApp() {
	System.out.println("Launch chrome browser");
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_c2a.04.30\\Desktop\\selenium drivers\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
    driver.findElement(By.linkText("SignIn")).click();
    driver.findElement(By.name("userName")).sendKeys("Laptop");
    driver.findElement(By.name("password")).sendKeys("vicky123");
    driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
}

@When("user search a particular product like headphones")
public void user_search_a_particular_product_like_headphones() {
	driver.findElement(By.xpath("//input[@type='text' and @name='products']")).sendKeys("head");
    driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
}

@When("try to proceed to payment without adding any item in the cart")
public void try_to_proceed_to_payment_without_adding_any_item_in_the_cart() {
	String cart=driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]/i")).getText();
	Assert.assertFalse(cart, false);
}

@Then("TestMe app doesn't display the cart icon")
public void testme_app_doesn_t_display_the_cart_icon() {
    System.out.println("TestMe app doesn't display the cart icon");
}
}
