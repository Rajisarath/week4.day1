package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAssi2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		//Topic : 
		WebElement frame1Topic = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1Topic);
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("selenium java");
		System.out.println("Topic Entered in Frame1");
		Thread.sleep(2000);
		
		//Inner Frame Check box :
		WebElement framecheckbox = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(framecheckbox);
		driver.findElement(By.xpath("//input[@id='a']")).click();
		System.out.println("Inner Frame Check box clicked");
		
		//Animals 
		driver.switchTo().defaultContent();
		WebElement framedropdownbox = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(framedropdownbox);
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='animals']"));
		//System.out.println("framedropdownbox clicked");
		
		
		Select sec1 = new Select(dropdown);
		sec1.selectByVisibleText("Avatar");
		WebElement firstSelectedOption = sec1.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println("framedropdownbox clicked : " + text);
		

		        
	}
}
