package by.htp.belavia.step;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import by.htp.belavia.driver.DriverSingleton;
import by.htp.belavia.entity.Ticket;
import by.htp.belavia.page.MainPage;
import by.htp.belavia.page.SearchForm;
import by.htp.belavia.page.SearchResultsForOneWayPage;

public class Steps {

	private WebDriver driver;

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}
	
	public void openMainPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
	}
	
	public void inputSearchFormOneWayForCurrentDate(String from, String to) {
		SearchForm searchForm = new SearchForm(driver);
		searchForm.inputFrom(from);
		searchForm.inputTo(to);
		searchForm.checkOneWay();
		searchForm.selectCurrentDepartureDate();
		searchForm.clickSearchButton();
	}
	
	public List<Ticket> listOfOneWayTickets(String endDate){
		SearchResultsForOneWayPage searchTickets = new SearchResultsForOneWayPage(driver);
		List<Ticket> tickets = searchTickets.listOfTickets(endDate);
			
		return tickets;		
	}
	
	public List<Ticket> listOfOneWayTicketsWithClasses(String endDate){
		SearchResultsForOneWayPage searchTickets = new SearchResultsForOneWayPage(driver);
		List<Ticket> tickets = searchTickets.listOfTicketsWithClasses(endDate);
		
		return tickets;
				
	}
}
