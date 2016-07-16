
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class WellsFargoTest {
	static WebDriver driver;
	
	@Test
	public void wellsFargoTest() throws IOException, InterruptedException{
		
		//Launch firefox 
		driver = new FirefoxDriver();
		
		//Launch Wells Fargo application
		driver.get("http://www.wellsfargo.com");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		//Verify you are 'Personal' tab
		WebElement personalTab1 = driver.findElement(By.xpath("//*[@id='tabNav']/ul/li[1]"));
		
		if(personalTab1.isDisplayed())
			System.out.println("We are on Personal tab");
		
		//Go to 'About Wells Fargo' 
		WebElement aboutWellsFargo = driver.findElement(By.xpath("//*[@id='headerTools']/nav/ul/li[2]/a"));
		aboutWellsFargo.click();
		
		//Verify you are on 'About Wells Fargo' 
		String title = driver.getTitle();
		if(title.equals("About Wells Fargo"))
			System.out.println("We are on About Wells Fargo tab");
		
		//Navigate back
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Verify you are 'Personal' tab
		WebElement personalTab2 = driver.findElement(By.xpath("//*[@id='tabNav']/ul/li[1]"));
		if(personalTab2.isDisplayed())
			System.out.println("We are on Personal tab again");
		Thread.sleep(2000);
		
		//Go to Insurance - Homeowners Insurance
		WebElement insurance = driver.findElement(By.xpath("//*[@id='insuranceTab']/a"));
		insurance.click();
		
	    
		WebElement homeownersIns1 = driver.findElement(By.xpath("//*[@id='insurance']/div[1]/div[2]/ul/li[1]/a"));
		homeownersIns1.click();
		
		Thread.sleep(2000);
		
		//Enter zipcode and click on continue
		WebElement zipCode = driver.findElement(By.xpath("//*[@id='zipCode']"));
		zipCode.sendKeys("95051");
		
		WebElement cont = driver.findElement(By.xpath("//*[@id='c28lastFocusable']"));
		cont.click();
		
		//Verify you are 'Homeowners Insurance' page
		WebElement homeownersIns2 = driver.findElement(By.xpath("//*[@id='skip']"));
		if(homeownersIns2.isDisplayed())
			System.out.println("We are on Homeowners Insurance page");
		
		
		String hTitle = driver.getTitle();
		if(hTitle.equals("Homeowners Insurance - Get Home Insurance Quotes - Wells Fargo Insurance")){
			System.out.println("We are on Homeowners Insurance page");
		}
		
		Thread.sleep(2000);
		
		//Take screenshot of the output page
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/Users/Pallavi/Desktop/Screenshots/output.jpg"));
		
		
		driver.quit();
		
	}
}
