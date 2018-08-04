package by.htp.belavia.page;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.belavia.entity.Ticket;

public class SearchResultsForOneWayPage extends AbstractPage {

	public SearchResultsForOneWayPage(WebDriver driver) {
		super(driver);
	}

	public List<Ticket> listOfTickets(String endDate) {
		List<Ticket> tickets = new LinkedList();

		label: do {
			List<WebElement> prices = driver.findElements(By.xpath("//div[@class='price']/div"));
			for (WebElement w : prices) {
				String price = w.getText();
				WebElement inputDate = w.findElement(By.xpath("input"));
				String date = inputDate.getAttribute("value");
				tickets.add(new Ticket(date, convertStringToDouble(price)));
				if (date.equals(endDate)) {
					break label;
				}
			}
			driver.findElement(By.xpath("//a[@data-val='next']")).click();
		} while (true);

		return tickets;
	}

	public List<Ticket> listOfTicketsWithClasses(String endDate) { //For one page..

		List<Ticket> tickets = new LinkedList();

		WebElement dateRadioBtn = driver.findElement(By.xpath("//*[@id=\"matrix\"]/div[6]/div/div[2]/div/label"));
		dateRadioBtn.click();

		WebElement nextStepBtn = driver.findElement(By.xpath("//button[@value='next']"));
		nextStepBtn.click();

		List<WebElement> endPrices = new ArrayList();

		endPrices = driver.findElements(By.xpath("//input[@type='radio']"));

		for (int i = 1; i <= endPrices.size(); i++) {
			String time = driver.findElement(By.xpath("//*[@id=\"outbound\"]/div[3]/div/div[1]/div[1]/strong")).getText();

			WebElement w = driver.findElement(By.xpath("(//input[@type='radio'])[" + i + "]/ancestor::*[1]"));
			String price = w.getAttribute("innerText").trim();
			String className = w.getAttribute("className");

			tickets.add(new Ticket("05 Aug", convertStringToDouble(price), className, time));
		}

		return tickets;

	}

	private double convertStringToDouble(String str) {
		str = str.replaceAll("0 BYN", "");
		double value = Double.parseDouble(str);
		return value;
	}

}
