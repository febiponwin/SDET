package Alation.SDET;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pages {
	
	WebDriver driver;
	WebElement element;
	
	public Pages(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean checkPresence(WebElement toCheck) {
		boolean check= true ;
		
		try {
			toCheck.isDisplayed();
		}catch(NoSuchElementException e) {
			check =false;
		}
		
		return check;
	}
	
	public WebElement getRootResults() {
		element = driver.findElement(By.xpath("//*[@id=\"s-results-list-atf\"]"));
		return element;
	}
	
	public WebElement getDropDown() {
		element = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		return element;
	}
	
	
	public WebElement getSearchField() {
		element = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		return element;
	}
	
	public WebElement getSearchIcon() {
		element = driver.findElement(By.xpath("//input[@value='Go']"));
		return element;
	}
	
	
	public WebElement getHeading(String id) {
		
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//*[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']"));
		return element;
	}
	
	public boolean checkHeading(String id) {
		
		boolean check = true;
		
		try {
		element =driver.findElement(By.xpath("//*[@id=\""+id+"\"]//*[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']"));
		}catch(NoSuchElementException e) {
			System.out.println("Element is not present");
			check = false;
		}
		
		
		return check;
		
	}
	
	
	public WebElement getAuthor(String id) {
		
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//*[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']/../following-sibling::div[1]/span[2]"));
				
		return element;
			
	}
	public WebElement getSecondAuthor(String id) {
		
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//*[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']/../following-sibling::div[1]/span[3]"));
				
		return element;
			
	}
	
	public boolean checkPaperback(String id) {
		boolean check =true;
		try {
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Paperback']"));
		}catch(NoSuchElementException e) {
			System.out.println("Element is not present");
			check=false;
		}
		return check;
	}
	
	public WebElement getPaperBack(String id) {
		element=driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Paperback']"));
		return element;
	}
	
	public WebElement getPaperBackFull(String id) {
		element = driver.findElement(By.xpath("(//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Paperback']/../following-sibling::div[1]/a//text())[1]"));
		return element;
		
	}
	
	
	public WebElement getWholePricePaperback(String id) {
		
		element = null;
		try {
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Paperback']/../following-sibling::div[1]/a//*[@class='sx-price-whole']"));
		}catch(NoSuchElementException e) {
			System.out.println("Element is not present");;
		}
		return element;
	}
	
	
	public WebElement getFractionalPricePaperback(String id) {
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Paperback']/../following-sibling::div[1]/a//*[@class='sx-price-fractional']"));
		return element;
	}
	
	
	public boolean checkKindle(String id) {
		boolean check =true;
		try {
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Kindle Edition']"));
		}catch(NoSuchElementException e) {
			System.out.println("Element is not present");
			check=false;
		}
		return check;
	}
	
	public WebElement getKindle(String id) {
		element=driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Kindle Edition']"));
		return element;
	}
	
	
	public WebElement getWholePriceKindle(String id) {
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Kindle Edition']/../following-sibling::div[1]/a//*[@class='sx-price-whole']"));
		return element;
	}
	
	
	public WebElement getFractionalPriceKindle(String id) {
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Kindle Edition']/../following-sibling::div[1]/a//*[@class='sx-price-fractional']"));
		return element;
	}
	
	
	public boolean checkHardCover(String id) {
		boolean check =true;
		try {
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Hardcover']"));
		}catch(NoSuchElementException e) {
			System.out.println("Element is not present");;
			check=false;
		}
		return check;
	}
	
	public WebElement getHardcover(String id) {
		element=driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Hardcover']"));
		return element;
	}
	
	
	public WebElement getWholePriceHardcover(String id) {
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Hardcover']/../following-sibling::div[1]/a//*[@class='sx-price-whole']"));
		return element;
	}
	
	
	public WebElement getFractionalHardcover(String id) {
		element = driver.findElement(By.xpath("//*[@id=\""+id+"\"]//a[@class='a-link-normal a-text-normal'][@title='Hardcover']/../following-sibling::div[1]/a//*[@class='sx-price-fractional']"));
		return element;
	}
	
	

}
