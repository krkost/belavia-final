package by.htp.belavia.page;

import java.util.LinkedList;
import java.util.List;

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

	private double convertStringToDouble(String str) {
		str = str.replaceAll("[ BYN]", "");
		double value = Double.parseDouble(str);
		return value;
	}

}
