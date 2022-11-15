package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAss {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Alert (Simple Dialog)
		
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String simpleAlertTxt = driver.findElement(By.xpath("//body[@class='main-body ui-input-filled']")).getText();
		if(simpleAlertTxt.contains("successfully"))
		{
		System.out.println("Simple Dialog Successfully executed ");
		
	     }else
	          {
		System.out.println("Simple Dialog not Successfully executed");
	          }
		
		//confirm alert
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		String text=alert.getText();
		System.out.println("Confirm Alert text is " +text);
		alert.dismiss();
		String confirmAlertResultTxt = driver.findElement(By.xpath("//span[@id='result']")).getText();
		if(confirmAlertResultTxt.contains("Cancel"))
				{
		           System.out.println("confirm alert clicking cancel ");
				}else
				{
					System.out.println("confirm alert accept by clicking oK ");
				}
		
		
		
		//Sweet Alert (Simple Dialog)
		driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
		String sweetAlertTxt = driver.findElement(By.xpath("(//p[contains(text(),'inspectable')])[1]")).getText();
		System.out.println("Sweet Alert Text : "+sweetAlertTxt);
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		//alert.dismiss();
		
		//Sweet Modal Dialog
		driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
		String sweetAlertModalTxt = driver.findElement(By.xpath("//p[contains(text(),'Unless')]")).getText();
		System.out.println("Sweet Modal Alert Text : "+sweetAlertModalTxt);
		//To click on x button in sweet modal alert
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]/parent::a")).click();
		Thread.sleep(2000);
		System.out.println("Sweet Alert Modal window Closed");
		
		//Alert (Prompt Dialog)
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		alert.sendKeys("Testleaf");
		String text2 = alert.getText();
		System.out.println(text2);
		alert.accept();
		String text3 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(text3);
		if(text3.contains("Testleaf")) {
			System.out.println("text is entered");
		}else {
			System.out.println("text is not entered");
		}


		//Sweet Alert (Confirmation)
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String sweetAlertDeleteTxt = driver.findElement(By.xpath("//span[@class='ui-confirm-dialog-message']")).getText();
		System.out.println("Sweet Alert Delete Msg :"+sweetAlertDeleteTxt);
		Thread.sleep(2000);
		//Clicking on No button
		driver.findElement(By.xpath("//span[text()='No']")).click();
		Thread.sleep(1000);
		
		
		//Minimize and Maximize
				
		driver.findElement(By.xpath("(//span[text()='Show'])[6]")).click();
		String minMaxText = driver.findElement(By.xpath("//p[contains(text(),'maximized')]")).getText();
		System.out.println("Min Max Text : "+minMaxText);
		//Clicking min button
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		
		//Clicking on + button to resume 
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-plus']")).click();
		
		//Clicking on Max button
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']")).click();
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick']/parent::a)[3]")).click();
		System.out.println(" Alert Closed Successfully");
	
	}
	

}
