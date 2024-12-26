package StepDefs;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArticlePosting {
	WebDriver driver;
	@Given("User is on Login page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://conduit-realworld-example-app.fly.dev/#/login");
	}
	@When("User provide {string} and {string}")
	public void user_provide_and(String strUser, String strPwd) {
		driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys(strUser);
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys(strPwd);
		driver.findElement(By.xpath("//button[@class = 'btn btn-lg btn-primary pull-xs-right']")).click();
	}
	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		
		Assert.assertEquals(driver.getTitle(), "Conduit");
   
	}
	
	@When("User provide invalid {string} and {string}")
	public void user_provide_invalid_and(String strUser1, String strPwd1) {
	driver.findElement(By.xpath("//input[@name = 'emai']")).sendKeys(strUser1);
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys(strPwd1);
		driver.findElement(By.xpath("//button[@class = 'btn btn-lg btn-primary pull-xs-right']")).click();
	}
	@Then("User should be on Home Page invalid")
	public void user_should_be_on_home_page_invalid() {
		
		Assert.assertEquals(driver.getTitle(), "Conduit");
   
	}
	
	@When("User provide negative {string} and {string}")
	public void user_provide_negative_and(String strUser2, String strPwd2) {
		driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys(strUser2);
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys(strPwd2);
		driver.findElement(By.xpath("//button[@class = 'btn btn-lg btn-primary pull-xs-right']")).click();
	}
	@Then("User should be on Home Page negative")
	public void user_should_be_on_home_page_negative() {
		
		Assert.assertEquals(driver.getTitle(), "Conduit");
   
	}
	
	
	@Given("User should be on New Article Page")
	public void user_should_be_on_new_article_page() throws InterruptedException {
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://conduit-realworld-example-app.fly.dev/#/login");
		driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("devamahe93@gmail.com");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Selenium@2468");
		driver.findElement(By.xpath("//button[@class = 'btn btn-lg btn-primary pull-xs-right']")).click();
	driver.get("https://conduit-realworld-example-app.fly.dev/#/");
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//i[@class = 'ion-compose']) [2]")).click();
	
	String Title = driver.findElement(By.xpath("//button[@class = 'btn btn-lg pull-xs-right btn-primary']")).getText();
	
	Assert.assertEquals(Title, "Publish Article");
	

	}

	@When("User enters Article details")
	public void user_enters_article_details(io.cucumber.datatable.DataTable datatable) {
		List<Map<String, String>> data = datatable.asMaps();
		 String arttitle = data.get(0).get("title");
		 String artdesc = data.get(0).get("Desc");
		 String artbody = data.get(0).get("Content");
		 String arttags = data.get(0).get("tag");
		driver.findElement(By.xpath("//input[@name= 'title']")).sendKeys(arttitle);
		driver.findElement(By.xpath("//input[@name= 'description']")).sendKeys(artdesc);
		driver.findElement(By.xpath("//textarea[@name= 'body']")).sendKeys(artbody);
		driver.findElement(By.xpath("//input[@name = 'tags']")).sendKeys(arttags);
		driver.findElement(By.xpath("//button[@class = 'btn btn-lg pull-xs-right btn-primary']")).click();
	}
	@Then("Article must be created")
	public void article_must_be_created() throws InterruptedException {
		Thread.sleep(5000);
		String Author = driver.findElement(By.xpath("//a[@class='author']")).getText();
		Assert.assertEquals(Author, "Devanand Reddy");
	}
	

	@Given("User should be on Global Feed page")
	public void user_should_be_on_global_feed_page() throws InterruptedException {
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://conduit-realworld-example-app.fly.dev/#/login");
    	driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("devamahe93@gmail.com");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Selenium@2468");
		driver.findElement(By.xpath("//button[@class = 'btn btn-lg btn-primary pull-xs-right']")).click();
		driver.get("https://conduit-realworld-example-app.fly.dev/#/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class = 'nav-link ']")).click();
	    
	}
	@When("User select an article {string}")
	public void user_select_an_article(String title) throws InterruptedException {
		Thread.sleep(5000);
	WebElement arttitle = driver.findElement(By.xpath("//a[@href = '#/article/selenium23453456']"));
	String Author = driver.findElement(By.xpath("//a[@class='author']")).getText();
	arttitle.click();
			
	 Assert.assertEquals(Author, title);
	 
	}
	@Then("Article detail page must be displayed")
	public void article_detail_page_must_be_displayed () throws InterruptedException {
		Thread.sleep(5000);
		String Author = driver.findElement(By.xpath("//a[@class='author']")).getText();
		Assert.assertEquals(Author, "Devanand Reddy");
	    
	}
	
	@Given("Article detail page must be displayed updated")
	public void article_detail_page_must_be_displayed_updated() throws InterruptedException {
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://conduit-realworld-example-app.fly.dev/#/login");
		driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("devamahe93@gmail.com");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Selenium@2468");
		driver.findElement(By.xpath("//button[@class = 'btn btn-lg btn-primary pull-xs-right']")).click();
		driver.get("https://conduit-realworld-example-app.fly.dev/#/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class = 'nav-link ']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href = '#/article/selenium23456356']")).click();
		Thread.sleep(5000);
		String Author = driver.findElement(By.xpath("//a[@class='author']")).getText();
		Assert.assertEquals(Author, "Devanand Reddy");   
	}
	@When("User update article detail")
	public void user_update_article_detail() {
		driver.findElement(By.xpath("//a[contains(text(),  'Edit Article')]")).click();
		WebElement title = driver.findElement(By.xpath("//input[@name= 'title']"));
	     title.clear();
		title.sendKeys("Seleniuuuuuummmmmm");
		driver.findElement(By.xpath("//button[@type= 'submit']")).click();
	}
	@Then("Article detail must be updated")
	public void article_detail_must_be_updated() throws InterruptedException {
		Thread.sleep(5000);
		String updtitle = driver.findElement(By.xpath("(//div[@class = 'container'])//h1")).getText();
		Assert.assertEquals(updtitle, "Seleniuuuuuummmmmm");
	}
	
	@Given("Article detail page must be displayed deleted")
	public void article_detail_page_must_be_displayed_deleted() throws InterruptedException {
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://conduit-realworld-example-app.fly.dev/#/login");
		driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("devamahe93@gmail.com");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Selenium@2468");
		driver.findElement(By.xpath("//button[@class = 'btn btn-lg btn-primary pull-xs-right']")).click();
		driver.get("https://conduit-realworld-example-app.fly.dev/#/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href = '#/article/Seleniuuuuuummmmmm']")).click();
		   
	}
	
	@When("User delete article")
	public void user_delete_article() throws InterruptedException {
	Thread.sleep(5000);
	   driver.findElement(By.xpath("//button[contains(text(),  ' Delete Article')]")).click();
	   Alert del = driver.switchTo().alert();
		del.accept();
	}
	@Then("Article must be deleted")
	public void article_must_be_deleted() {
		
		WebElement article = driver.findElement(By.xpath("(//div[@class = 'container'])//h1"));
		if (article.equals(null)) {
			System.out.println("The Article is not Deleted.");
				}
		else {
				System.out.println("The Article is deleted.");
			
		}		
	}
	
	@After
	public void attachScreenshot(Scenario scenario)
	{
		if (scenario.isFailed()) {
			TakesScreenshot scr = (TakesScreenshot)driver;
			byte[] img = scr.getScreenshotAs(OutputType.BYTES);
			scenario.attach(img, "image/png", "Screenshot");
					
		}}

}
