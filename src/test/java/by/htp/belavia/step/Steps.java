package by.htp.belavia.step;

import org.openqa.selenium.WebDriver;

import by.htp.belavia.driver.DriverSingleton;
import by.htp.belavia.page.MainPage;
import by.htp.belavia.page.SearchForm;

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
}
