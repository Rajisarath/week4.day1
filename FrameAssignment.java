package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//switch to frame using index
		//Click Me (Inside frame)
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//button[@id='Click'])[1]")).click();
		System.out.println("Inside frame is clicked");
		
		//How many frames in this page?
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//button[text()='Count Frames']")).click();
		System.out.println("click on countframe button");
		
		driver.switchTo().defaultContent();
		
		 java.util.List<WebElement> nocount = driver.findElements(By.tagName("iframe"));
		 System.out.println("no of countframe: "+ nocount.size() );
		
		
		//Click Me (Inside Nested frame)
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		System.out.println("Inside Nested frame button clicked");

		
		
		

	}

}
