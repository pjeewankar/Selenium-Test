
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AmazonTests extends ReusableMethods{
	static WebDriver driver;
	
	//TC001
	@Test
	public void launchAmazon() throws InterruptedException, IOException{
		startReport("Launch Amazon", "/Users/Pallavi/Desktop/Screenshots/");
		
		//Launch firefox
		driver = new FirefoxDriver();
		
		//Launch Amazon application
		driver.get("https://www.amazon.com/");
		
		Update_Report("Pass", "Launch Amazon application", "Amazon application is launched.");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		
		if(url.equals("https://www.amazon.com/"))
			Update_Report("Pass", "Launch Amazon", "Application launched successfully");
		
		driver.quit();
			
	}
	
	//TC002
	@Test
	public void verifyDropdown() throws IOException, InterruptedException{
		startReport("Verify Dropdown", "/Users/Pallavi/Desktop/Screenshots/");
		
		//Launch firefox
		driver = new FirefoxDriver();
		
		//Launch Amazon application
		driver.get("https://www.amazon.com/");
		
		Update_Report("Pass", "Launch Amazon application", "Amazon application is launched.");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		//Enter iPhone in Search box
		WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		enterText(searchBox, "iPhone", "Search Box");
		
		Thread.sleep(3000);
		
		//Validate 1st drop down
		WebElement firstDropdown = driver.findElement(By.xpath("//*[@id='issDiv0']"));
		String expected1stDropdownText = "Iphone 6s case in All Departments";

		validateTextMessage(firstDropdown, "1st Drop down", expected1stDropdownText);
		
		//Validate 2nd drop down
		WebElement secondDropdown = driver.findElement(By.xpath("//*[@id='issDiv1']"));
		String expected2ndDropdownText = "Iphone 6s case in Electronics";

		validateTextMessage(secondDropdown, "2nd Drop down", expected2ndDropdownText);

		
		//Validate 3rd drop down
		WebElement thirdDropdown = driver.findElement(By.xpath("//*[@id='issDiv2']"));
		String expected3rdDropdownText = "Iphone 6s case in Electronics";

		validateTextMessage(thirdDropdown, "3rd Drop down", expected3rdDropdownText);
		
		driver.quit();
	}
	
	//TC003
	@Test
	public void clickSearch() throws IOException, InterruptedException{
		startReport("Click Search", "/Users/Pallavi/Desktop/Screenshots/");

		//Launch firefox
		driver = new FirefoxDriver();

		//Launch Amazon application
		driver.get("https://www.amazon.com/");

		Update_Report("Pass", "Launch Amazon application", "Amazon application is launched.");

		driver.manage().window().maximize();

		Thread.sleep(2000);
		
		//Enter iPhone in Search box
		WebElement searchText = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		enterText(searchText, "iPhone", "Search Text");
		
		Thread.sleep(3000);
		//Click Search button
		WebElement searchB = driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div/input"));
		clickElement(searchB, "Click Search");	
		
		WebElement displayResult = driver.findElement(By.xpath("//*[@id='s-result-count']"));
		if(displayResult.isDisplayed()){
			Update_Report("Pass", "Display Results", "Results are displayed");
		}
		
		//System.out.println(searchB.getCssValue("cursor"));	
		
	}
	
	//TC004
	@Test
	public void verifyShowResults1() throws IOException, InterruptedException{
		startReport("Verify Show Results 1", "/Users/Pallavi/Desktop/Screenshots/");

		//Launch firefox
		driver = new FirefoxDriver();

		//Launch Amazon application
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");

		Update_Report("Pass", "Verify Show Results", "Amazon application is launched.");

		driver.manage().window().maximize();

		Thread.sleep(2000);
		
		
		WebElement cellPhoneAccessoryKit = driver.findElement(By.xpath("//*[@id='refinements']/div[2]/ul[1]/li[3]/a/span[1]"));
		String expectedcellPhoneAccessoryKit = "Cell Phone Accessory Kits";
		validateTextMessage(cellPhoneAccessoryKit, "Cell Phone Accessory Kits option", expectedcellPhoneAccessoryKit);
	
		
		WebElement accessories = driver.findElement(By.xpath("//*[@id='refinements']/div[2]/ul[1]/li[4]/a/span[1]"));
		String expectedAccessories = "Accessories";
		validateTextMessage(accessories, "Accessories option", expectedAccessories );
		

		WebElement cellPhoneCases = driver.findElement(By.xpath("//*[@id='refinements']/div[2]/ul[1]/li[5]/a/span[1]"));
		String expectedcellPhoneCases = "Cell Phone Cases";
		validateTextMessage(cellPhoneCases, "Cell Phone Cases option", expectedcellPhoneCases);
		
		
		WebElement seeMore = driver.findElement(By.xpath("//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
		String expectedseeMore = "See More";
		validateTextMessage(seeMore, "See More option", expectedseeMore);
		
		driver.quit();
		
	}
	
	//TC005
	@Test
	public void verifyShowResults2() throws IOException, InterruptedException{
		startReport("Verify Show Results 2", "/Users/Pallavi/Desktop/Screenshots/");

		//Launch firefox
		driver = new FirefoxDriver();

		//Launch Amazon application
		driver.get("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");

		Update_Report("Pass", "Verify Show Results", "Amazon application is launched.");

		driver.manage().window().maximize();

		Thread.sleep(2000);
		
		WebElement cellPhoneAccessories = driver.findElement(By.xpath("//*[@id='refinements']/div[2]/ul[1]/li[2]/strong"));
		String expectedcellPhoneAccessories = "Cell Phone & Accessories";
		validateTextMessage(cellPhoneAccessories, "Cell Phone & Accessories option", expectedcellPhoneAccessories);
		
		driver.quit();
	}
	
	//TC006
	//@Test
	public void verifyShowResultsElectronics() throws IOException, InterruptedException{
		startReport("Verify Show Results Electrincs", "/Users/Pallavi/Desktop/Screenshots/");

		//Launch firefox
		driver = new FirefoxDriver();

		//Launch Amazon application
		driver.get("https://www.amazon.com/s/ref=nb_sb_ss_c_2_6?url=search-alias%3Delectronics&field-keywords=iphone+6s+case&sprefix=undefined%2Caps%2C309");

		Update_Report("Pass", "Verify Show Results Electronics", "Amazon application is launched.");

		driver.manage().window().maximize();

		Thread.sleep(2000);
		
		WebElement electronics = driver.findElement(By.xpath("//*[@id='s-result-info-bar-content']/div[1]"));
		String expectedElectronics = "Electronics";
		validateTextMessage(electronics, "Electronics Menu", expectedElectronics);
		
		WebElement cellPhoneCases = driver.findElement(By.xpath("//*[@id='refinements']/div[2]/ul[1]/li[3]/a/span[1]"));
		String expectedCellPhoneCases = "Cell Phone Cases";
		validateTextMessage(cellPhoneCases, "Cell Phone Cases", expectedCellPhoneCases);
		
		WebElement accessoriesAndSupply = driver.findElement(By.xpath("//*[@id='refinements']/div[2]/ul[1]/li[4]/a/span[1]"));
		String expectedAccessoriesAndSupply = "Accessories And Supply";
		validateTextMessage(accessoriesAndSupply, "Accessories And Supply", expectedAccessoriesAndSupply);
		
		WebElement seeMore = driver.findElement(By.xpath("//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
		String expectedseeMore = "See More";
		validateTextMessage(seeMore, "See More option", expectedseeMore);
		
		driver.quit();
	}
	
	
	//TC007
	@Test
	public void verifyLeftColumn() throws IOException, InterruptedException{
		startReport("Verify Show Results 2", "/Users/Pallavi/Desktop/Screenshots/");

		//Launch firefox
		driver = new FirefoxDriver();

		//Launch Amazon application
		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");

		Update_Report("Pass", "Verify Show Results", "Amazon application is launched.");

		driver.manage().window().maximize();

		Thread.sleep(2000);
		
		WebElement amazonPrime = driver.findElement(By.xpath("//*[@id='refinements']/h2[1]"));
		if(amazonPrime.isDisplayed())
			Update_Report("Amazon Prime", "Amazon Prime displayed", "Amazon Prime is displayed.");
		
		WebElement prime = driver.findElement(By.xpath("//*[@id='ref_2470954011']/li[2]"));
		if(!prime.isSelected())
			Update_Report("Pass", "Check Prime", "Prime is unchecked");
		
		
		WebElement eligible = driver.findElement(By.xpath("//*[@id='refinements']/h2[2]"));
		if(eligible.isDisplayed())
			Update_Report("Pass", "Eligible for free shipping", "Eligible for free shipping is displayed.");
		
		WebElement freeShipping = driver.findElement(By.xpath("//*[@id='ref_2470954011']/li"));
		if(!freeShipping.isSelected())
			Update_Report("Pass", "Free Shipping By Amazon", "Free Shipping By Amazon is unchecked");
		
		
		WebElement brand = driver.findElement(By.xpath("//*[@id='refinements']/h2[4]"));
		if(brand.isDisplayed())
			Update_Report("Pass", "Eligible for free shipping", "Eligible for free shipping is displayed.");
		
		WebElement apple = driver.findElement(By.xpath("//*[@id='ref_2528832011']/li[1]"));
		if(!apple.isSelected())
			Update_Report("Pass", "Apple", "Apple is unchecked");
		

		WebElement cellPhoneMem = driver.findElement(By.xpath("//*[@id='refinements']/h2[5]"));
		if(cellPhoneMem .isDisplayed())
			Update_Report("Pass", "Cell Phone Internal Memory", "Cell Phone Internal Memory is displayed.");
		
		WebElement fourMB = driver.findElement(By.xpath("//*[@id='ref_7805160011']/li[1]"));
		if(!fourMB.isSelected() && fourMB.isDisplayed() && !fourMB.isEnabled())
			Update_Report("Pass", "4 MB", "4 MB is unchecked, displayed an ddeactivated");
		
		WebElement eightMB = driver.findElement(By.xpath("//*[@id='ref_7805160011']/li[2]"));
		if(!eightMB.isSelected() && eightMB.isDisplayed() )
			Update_Report("Pass", "8 MB", "8 MB is displayed and unchecked ");
		
		WebElement sixteenMB = driver.findElement(By.xpath("//*[@id='ref_7805160011']/li[3]"));
		if(!sixteenMB.isSelected() && sixteenMB.isDisplayed() )
			Update_Report("Pass", "16 MB", "16 MB is displayed and unchecked");
		
		WebElement thirtyTwoMB = driver.findElement(By.xpath("//*[@id='ref_7805160011']/li[4]"));
		if(!thirtyTwoMB.isSelected() && thirtyTwoMB.isDisplayed() )
			Update_Report("Pass", "32 MB", "32 MB is displayed and unchecked ");
		
		WebElement sixtyFourMB = driver.findElement(By.xpath("//*[@id='ref_7805160011']/li[5]"));
		if(!sixtyFourMB.isSelected() && sixtyFourMB.isDisplayed() )
			Update_Report("Pass", "64 MB", "64 MB is displayed and unchecked");
	}
	
	//TC008
	@Test
	public void checkMainTab() throws IOException, InterruptedException{
		startReport("Verify Show Results Electrincs", "/Users/Pallavi/Desktop/Screenshots/");

		//Launch firefox
		driver = new FirefoxDriver();

		//Launch Amazon application
		driver.get("https://www.amazon.com");

		Update_Report("Pass", "Verify Show Results Electronics", "Amazon application is launched.");

		driver.manage().window().maximize();

		Thread.sleep(2000);
		
		WebElement departments = driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]"));
		String expectedDepartments = "Departments";
		validateTextMessage(departments, "Departments Menu", expectedDepartments);
		
		WebElement yourAmazon = driver.findElement(By.xpath("//*[@id='nav-your-amazon']"));
		String expectedYourAmazon = "Your Amazon.com";
		validateTextMessage(yourAmazon, "You Amazon", expectedYourAmazon);
		
		WebElement todaysDeals = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[2]"));
		String expectedTodaysDeals = "Today's Deals";
		validateTextMessage(todaysDeals, "Today's Deals", expectedTodaysDeals);
		
		WebElement giftsAndReg = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[3]"));
		String expectedGiftsAndReg = "Gift Cards & Registry";
		validateTextMessage(giftsAndReg, "Gift Cards & Registry", expectedGiftsAndReg);
		
		WebElement sell = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[4]"));
		String expectedSell = "Sell";
		validateTextMessage(sell, "Sell", expectedSell);
		
		WebElement help = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[5]"));
		String expectedHelp = "Help";
		validateTextMessage(help, "Help", expectedHelp);
		
		WebElement yourAccount = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
		String expectedyourAccount = "Hello, Sign in Your Account";
		validateTextMessage(yourAccount, "Today's Deals", expectedyourAccount );
		
		WebElement tryPrime = driver.findElement(By.xpath("//*[@id='nav-link-prime']/span[2]"));
		String expectedtryPrime = "Try Prime";
		validateTextMessage(tryPrime, "Try Prime", expectedtryPrime);
		

		WebElement lists = driver.findElement(By.xpath("//*[@id='nav-link-wishlist']/span[2]"));
		String expectedLists = "Lists";
		validateTextMessage(lists, "Lists", expectedLists);
		
		WebElement cart = driver.findElement(By.xpath("//*[@id='nav-cart']/span[2]"));
		String expectedCart = "Cart";
		validateTextMessage(cart, "Cart", expectedCart);
		
		driver.quit();
	}
	
	
	
	//TC009
		@Test
		public void validateDepartmentDropdown() throws IOException, InterruptedException{
			startReport("Verify Show Results Electrincs", "/Users/Pallavi/Desktop/Screenshots/");

			//Launch firefox
			driver = new FirefoxDriver();

			//Launch Amazon application
			driver.get("https://www.amazon.com");

			Update_Report("Pass", "Verify Show Results Electronics", "Amazon application is launched.");

			driver.manage().window().maximize();

			Thread.sleep(2000);

			WebElement departments = driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]"));
			clickElement(departments, "departments");
			
			Actions action = new Actions(driver);    

			action.moveToElement(departments);

			List<WebElement> options = driver.findElements(By.xpath("//span[contains(@class, 'nav-text')]"));
			for(WebElement option : options) {
			    if (option.getText().equals("Amazon Video")) {
			       clickElement(option, "Amazon Video");
			    }
			}
			Thread.sleep(2000);
			driver.quit();
		}
		
		//TC010
		@Test
		public void validateYourAcctDropdown() throws IOException, InterruptedException{
			startReport("Verify Show Results Electrincs", "/Users/Pallavi/Desktop/Screenshots/");

			//Launch firefox
			driver = new FirefoxDriver();

			//Launch Amazon application
			driver.get("https://www.amazon.com");

			Update_Report("Pass", "Verify Show Results Electronics", "Amazon application is launched.");

			driver.manage().window().maximize();

			Thread.sleep(2000);

			WebElement yourAccount = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
			clickElement(yourAccount, "Your Account");
			
			Actions action = new Actions(driver);    

			action.moveToElement(yourAccount);

			List<WebElement> options = driver.findElements(By.xpath("//span[contains(@class, 'nav-text')]"));
			for(WebElement option : options) {
			    if (option.getText().equals("Your Account")) {
			       clickElement(option, "Your Account");
			    }
			}

			Thread.sleep(2000);
			driver.quit();
		}
		
		//TC011
		@Test
		public void tryPrimeDropdown() throws IOException, InterruptedException{
			startReport("Verify Show Results Electrincs", "/Users/Pallavi/Desktop/Screenshots/");

			//Launch firefox
			driver = new FirefoxDriver();

			//Launch Amazon application
			driver.get("https://www.amazon.com");

			Update_Report("Pass", "Verify Show Results Electronics", "Amazon application is launched.");

			driver.manage().window().maximize();

			Thread.sleep(2000);

			WebElement tryPrime = driver.findElement(By.xpath("//*[@id='nav-link-prime']/span[2]"));
			clickElement(tryPrime, "Try Prime");

			Actions action = new Actions(driver);    

			action.moveToElement(tryPrime);

			
			List<WebElement> options = driver.findElements(By.xpath("//span[contains(@class, 'nav-text')]"));
			for(WebElement option : options) {
				if (option.getText().equals("Amazon Video")) {
					clickElement(option, "Amazon Video");
				}
			}
			Thread.sleep(2000);
			driver.quit();

		}
		
		//TC012
		@Test
		public void listsDropdown() throws IOException, InterruptedException{
			startReport("Verify Show Results Electrincs", "/Users/Pallavi/Desktop/Screenshots/");

			//Launch firefox
			driver = new FirefoxDriver();

			//Launch Amazon application
			driver.get("https://www.amazon.com");

			Update_Report("Pass", "Verify Show Results Electronics", "Amazon application is launched.");

			driver.manage().window().maximize();

			Thread.sleep(2000);


			WebElement lists = driver.findElement(By.xpath("//*[@id='nav-link-wishlist']/span[2]"));
			clickElement(lists, "Lists");

			Actions action = new Actions(driver);    

			action.moveToElement(lists);

			List<WebElement> options = driver.findElements(By.xpath("//span[contains(@class, 'nav-text')]"));
			for(WebElement option : options) {
				if (option.getText().equals("Create a List")) {
					clickElement(option, "Create a List");
				}
			}
			Thread.sleep(2000);
			driver.quit();
		}
		
}
