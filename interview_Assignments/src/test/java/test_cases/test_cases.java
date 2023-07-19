package test_cases;

import java.net.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.url_Checker;


public class test_cases {
	WebDriver driver;
	WebElement image; 
	String imgSrc;
	URLConnection urlConnection;
	HttpURLConnection httpURLConnection;
	Boolean response;
	WebElement upload_locator;
	url_Checker url_Test = new url_Checker();
	String path;
	String submit_message;
	String submit_message_dom;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test(enabled = true)
	public void first_image() throws Exception {
		try {
			driver.get("http://the-internet.herokuapp.com/broken_images");
			Thread.sleep(2000);
			image = driver.findElement(By.xpath("(//img[@src])[2]"));
			imgSrc = image.getAttribute("src");
			response = url_Test.urlCheck(imgSrc);
			Assert.assertTrue(response);
		}catch (Exception e) {
			System.err.println(e);
		}	
	}
	
	@Test(enabled = true)
	public void second_image() throws Exception {
		try {
			Thread.sleep(2000);
			image = driver.findElement(By.xpath("(//img[@src])[3]"));
			imgSrc = image.getAttribute("src");
			response = url_Test.urlCheck(imgSrc);
			Assert.assertTrue(response);
		}catch (Exception e) {
			System.err.println(e);
		}	
	}
	
	@Test(enabled = true)
	public void third_image() throws Exception {
		try {
			Thread.sleep(2000);
			image = driver.findElement(By.xpath("(//img[@src])[4]"));
			imgSrc = image.getAttribute("src");
			System.out.println(imgSrc);
			response = url_Test.urlCheck(imgSrc);
			System.out.println(response);
			Assert.assertTrue(response);
		}catch (Exception e) {
			System.err.println(e);
		}	
	}
	
	@Test(enabled = true)
	public void upload_file() {
		try {
			driver.get("http://the-internet.herokuapp.com/upload");
			upload_locator = driver.findElement(By.id("file-upload"));
			path = "C:\\Users\\ajay rafayal\\Desktop\\supermacy.jpeg";
			upload_locator.sendKeys(path);
			Thread.sleep(2000);
			driver.findElement(By.id("file-submit")).click();
			submit_message = "File Uploaded!";
			submit_message_dom = driver.findElement(By.tagName("h3")).getText();
			Assert.assertEquals(submit_message, submit_message_dom);
		} catch (Exception e) {
			System.err.println(e);
		}finally {
			driver.close();	
		}
	}
}
