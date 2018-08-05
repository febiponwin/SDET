package Alation.SDET;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class NewTest {
	WebDriver driver;
  @Test
  public void f() {
	  
	  System.out.println(driver.getTitle());
	  
	  /*
	   * Asserting whether the results is based on given input
	   */
	
	  Assert.assertEquals(driver.getTitle(), "Amazon.com: data catalog: Books");

	  
	  //Accessing pages which has all the required elements
	  Pages pa = new Pages(driver);
	  
	  

	  //using tag li the results present in single screen is obtained
	  List<WebElement> results = pa.getRootResults().findElements(By.tagName("li"));
	  
	  //this list of list is to  store all the values from the screen
	  List<List<String>> storeValue = new ArrayList<>();
	 
	  //this for loop is for iterating and get the results in the screen without clicking and opening it
	  for(int i=0;i<results.size();i++) {
		  List<String> lineValues = new ArrayList<>();
		  System.out.println(results.get(i).getAttribute("id"));
		  
		  String value = results.get(i).getAttribute("id");
		  
		 
		  /*
		   * Below block of code gets value of each book heading and authors from screen
		   */
		  if(pa.checkHeading(value)) {
			   
			   lineValues.add(String.valueOf(i+1));
			   System.out.println("Book Title: "+pa.getHeading(value).getText());
			   lineValues.add(pa.getHeading(value).getText());
			   
			   
			   if(pa.getAuthor(value).getText().trim().substring(pa.getAuthor(value).getText().length()-4).equalsIgnoreCase(" and")) {
				   System.out.println("Authors "+pa.getAuthor(value).getText()+" "+pa.getSecondAuthor(value).getText());  
				   lineValues.add(pa.getAuthor(value).getText()+" "+pa.getSecondAuthor(value).getText());
			   }else {
				   lineValues.add(pa.getAuthor(value).getText());
				   System.out.println("Authors "+pa.getAuthor(value).getText());   
			   }
			   
		  }
		  
		  
		  /*
		   * Below block of code checks whether for the particular screen paperback is present and the values
		   */
		  if(pa.checkPaperback(value)) {

			  System.out.println(pa.getPaperBack(value).getText());
			  
			  
			  
			  if(pa.getWholePricePaperback(value)!=null) {
			  lineValues.add(pa.getWholePricePaperback(value).getText()+"."+pa.getFractionalPricePaperback(value).getText());
			  System.out.println("Cost "+pa.getWholePricePaperback(value).getText()+"."+pa.getFractionalPricePaperback(value).getText());
			  }
			  else {
				  lineValues.add("");
				 
			  }
			  		  
		  }else {
			  lineValues.add("");
		  }
		  
		  
		  /*
		   * Below block of code checks whether the Hardcover for the book is present and its price/cost
		   */
		  if(pa.checkHardCover(value)) {

			  System.out.println(pa.getHardcover(value).getText());

			  
			  System.out.println("Cost "+pa.getWholePriceHardcover(value).getText()+"."+pa.getFractionalHardcover(value).getText());
			  lineValues.add(pa.getWholePriceHardcover(value).getText()+"."+pa.getFractionalHardcover(value).getText());
			  		  
		  }else {
			  lineValues.add("");
		  }
		  
		  
		  
		  /*
		   * Below block of code check whether the Kindle edition is present for the book and its price if present
		   */
		  if(pa.checkKindle(value)) {

			  System.out.println(pa.getKindle(value).getText());

			  
			  lineValues.add(pa.getWholePriceKindle(value).getText()+"."+pa.getFractionalPriceKindle(value).getText());
			  System.out.println("Cost "+pa.getWholePriceKindle(value).getText()+"."+pa.getFractionalPriceKindle(value).getText());
			  		  
		  }else {
			  lineValues.add("");
		  }
		  
		    
		  storeValue.add(lineValues);//storing all the details for the book as a list
		  
	  }
	  
	 for(List<String> value:storeValue) {
		 for(String lines:value) {
			 System.out.print(lines+"\t");
		 }
		 System.out.println();
	 }
	 
	 //csv file writing
	 //generate current date
	 Date date = new Date();
	 SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
	 String fileName = "Results_on_"+formatter.format(date)+".csv";
	 
	 CSVWriter.writeCSV(storeValue, fileName);
	 
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver.get("https://www.amazon.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  Pages pg = new Pages(driver);
	  
	  //select books from drop down
	  
	  Select dropdown = new Select(pg.getDropDown());
	  dropdown.selectByVisibleText("Books");
	  
	    
	  //type the keyword
	  
	  pg.getSearchField().sendKeys("data catalog");
	  
	  //hit enter
	  pg.getSearchIcon().click();
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeSuite
  public void beforeSuite() {
	// Launch the browser
				System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
				driver=new ChromeDriver();


	  
	  
				System.out.println("Driver initiatied");
  }

  @AfterSuite
  public void afterSuite() {
	  driver.quit();
  }

}
