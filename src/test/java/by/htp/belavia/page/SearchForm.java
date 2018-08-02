package by.htp.belavia.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchForm extends AbstractPage{
	
	private WebElement from;
	private WebElement to;
	private WebElement oneWayRadioBtn;
	private WebElement departureFieldCalendar;
	private WebElement departureDate;
	private WebElement searchBtn;
	
	public SearchForm(WebDriver driver) {
		super(driver);
	}
	
	public void inputFrom(String fromDirection) {
		from = driver.findElement(By.xpath("//input[@name='OriginLocation_Combobox']"));
		from.sendKeys(fromDirection);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']")).click();
	}
	
	public void inputTo(String toDirection) {
		to = driver.findElement(By.xpath("//input[@name='DestinationLocation_Combobox']"));
		to.sendKeys(toDirection);
		driver.findElement(By.xpath("//*[starts-with(@id, 'ui-id')]")).click();
	}
	
	public void checkOneWay() {
		oneWayRadioBtn = driver.findElement(By.xpath("//label[@for='JourneySpan_Ow']"));
		oneWayRadioBtn.click();
	}
	
	public void selectCurrentDepartureDate() {
		departureFieldCalendar = driver.findElement(By.xpath("(//a[@class='trigger'])[3]"));
		departureFieldCalendar.click();
		departureDate = driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ui-state-hover']"));
		departureDate.click();
	}
	
	public void clickSearchButton() {
		searchBtn = driver.findElement(By.xpath("(//button[@class='button btn-large btn btn-b2-green ui-corner-all'])[1]"));
		searchBtn.click();
	}
	
	

}
