package by.htp.belavia.page;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.belavia.entity.Ticket;

public class SearchResultsForOneWayPage extends AbstractPage {

	WebElement nextStepBtn = driver.findElement(By.xpath("//button[@value='next']"));
	

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
				tickets.add(new Ticket(date, convertStringToDouble(price, "[ BYN]")));
				if (date.equals(endDate)) {
					break label;
				}
			}
			driver.findElement(By.xpath("//a[@data-val='next']")).click();
		} while (true);

		return tickets;
	}
	

	public List<Ticket> listOfTicketsWithClasses(String endDate) { // For one page..

		List<Ticket> tickets = new LinkedList();
		int i = 1;
		String lastSavedDate = "";

		label: while (true) {

			List<WebElement> slots = driver.findElements(By.xpath("//div[@class='price']/div"));

			for (WebElement slot : slots) {

				slot = driver.findElement(By.xpath("(//div[@class='price'])[" + i + "]"));
				WebElement inputDate = slots.get(i - 1).findElement(By.xpath("input"));
				String date = inputDate.getAttribute("value");
				
				//If we start search with already saved date, shift id and start again
				if (date.equals(lastSavedDate)) {
					i++;
					continue label;
				}

				slot.click();
				nextStepBtn.click();
				
				//Take data for tickets from one page
				List<WebElement> endPrices = driver.findElements(By.xpath("//input[@type='radio']"));
				
				for (int j = 1; j <= endPrices.size(); j++) {
					String time = driver.findElement(By.xpath("//*[@id=\"outbound\"]/div[3]/div/div[1]/div[1]/strong")).getText();
					WebElement w = driver.findElement(By.xpath("(//input[@type='radio'])[" + j + "]/ancestor::*[1]"));
					String price = w.getAttribute("innerText").trim();
					String className = w.getAttribute("className");

					tickets.add(new Ticket(date, convertStringToDouble(price, "0 BYN"), className, time));
				}
				
				if (date.equals(endDate)) {
					break label;
				}

				lastSavedDate = date;
				WebElement fareCalendar = driver.findElement(By.xpath("//a[contains(text(), 'Fare calendar')]"));
				fareCalendar.click();
			}

		}
		return tickets;
	}

	private double convertStringToDouble(String str, String forRemove) {
		str = str.replaceAll(forRemove, "");
		double value = Double.parseDouble(str);
		return value;
	}

}
